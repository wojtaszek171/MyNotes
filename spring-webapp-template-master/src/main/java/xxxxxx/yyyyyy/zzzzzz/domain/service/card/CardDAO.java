package xxxxxx.yyyyyy.zzzzzz.domain.service.card;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Card;
import xxxxxx.yyyyyy.zzzzzz.domain.service.board.BoardDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CardDAO {


    @Autowired
    private JdbcTemplate jdbctemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbctemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public void insert(Card card){
        String sqlinsert ="INSERT INTO `card` (`CARD_TITLE`, `CARD_COLOR`, `CARD_BACKGROUND`, `CARD_X`, `CARD_Y`, `ID_BOARD`, `CREATED_AT`,`UPDATED_AT`)"
                + " VALUES (?, ?, ? , ?, ?, ?, ?, ?)";
        String title = card.getTitle();
        String color = card.getColor();
        Integer boardId = Integer.valueOf(card.getId_board());
        Date date = DateTime.now().toDate();
        getJdbcTemplate().update(sqlinsert,new Object[]{title,color, "", 0, 0, boardId,date,date});

    }

    public ArrayList<Card> getCards(int idBoard){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String selectAllSql = "SELECT * FROM card WHERE ID_BOARD = ?";
        ArrayList<Card> cards = new ArrayList<Card>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(selectAllSql, idBoard);
        for (Map row : rows) {
            Card card = new Card();
            card.setTitle((String) row.get("CARD_TITLE"));
            card.setColor((String) row.get("CARD_COLOR"));
            card.setId_board((int) row.get("ID_BOARD"));
            card.setId((int) row.get("CARD_ID"));
            cards.add(card);
        }
        return cards;
    }
}
