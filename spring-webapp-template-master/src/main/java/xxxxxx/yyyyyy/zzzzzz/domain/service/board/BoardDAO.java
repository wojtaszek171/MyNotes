package xxxxxx.yyyyyy.zzzzzz.domain.service.board;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BoardDAO {

    @Autowired
    private JdbcTemplate jdbctemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbctemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public void insert(Board board){
        String sqlinsert ="INSERT INTO `board` (`BOARD_NAME`, `BOARD_COLOR`, `BOARD_BACKGROUND`, `ID_USER`, `CREATED_AT`, `UPDATED_AT`)"
                + " VALUES (?, ?, ? , ?, ?, ?)";
        String name = board.getName();
        String color = board.getColor();
        Integer userId = Integer.valueOf(board.getId_user());
        Date date = DateTime.now().toDate();
        getJdbcTemplate().update(sqlinsert,new Object[]{name,color, "", userId,date,date});

    }

    public List<Board> selectAll(Integer id){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String selectAllSql = "SELECT * FROM board WHERE ID_USER = ?";

        List<Board> boards = new ArrayList<>();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(selectAllSql,id);
        for (Map row : rows) {
            Board board = new Board();
            board.setName((String) row.get("BOARD_NAME"));
            board.setColor((String) row.get("BOARD_COLOR"));
            board.setId_user((int) row.get("ID_USER"));
            board.setId((int) row.get("BOARD_ID"));
            boards.add(board);
        }

        return boards;
    }
    public Board getUserBoard(Integer idUser, Integer idBoard){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String selectAllSql = "SELECT * FROM board WHERE ID_USER = ? AND BOARD_ID = ?";
        Board board = new Board();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(selectAllSql,new Object[]{idUser,idBoard});
        for (Map row : rows) {
            board.setName((String) row.get("BOARD_NAME"));
            board.setColor((String) row.get("BOARD_COLOR"));
            board.setId_user((int) row.get("ID_USER"));
            board.setId((int) row.get("BOARD_ID"));
        }
        return board;
    }
    public boolean deleteUserBoard(Integer idBoard, Integer idUser){
        Board board = getUserBoard(idUser, idBoard);
        if(board.getId()!=null){
            SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String deleteQuery = "DELETE FROM board WHERE BOARD_ID = ?";
            getJdbcTemplate().update(deleteQuery,idBoard);
            return true;
        }
        return false;
    }

}
