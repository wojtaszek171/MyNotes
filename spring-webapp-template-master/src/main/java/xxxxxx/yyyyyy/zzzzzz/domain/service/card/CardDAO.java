package xxxxxx.yyyyyy.zzzzzz.domain.service.card;

import org.aspectj.weaver.ast.Not;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Card;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Note;
import xxxxxx.yyyyyy.zzzzzz.domain.service.board.BoardDAO;

import java.util.*;

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
        ArrayList<Card> cards = new ArrayList<>();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(selectAllSql, idBoard);

        for (Map row : rows) {
            Card card = new Card();
            card.setTitle((String) row.get("CARD_TITLE"));
            card.setColor((String) row.get("CARD_COLOR"));
            card.setId_board((int) row.get("ID_BOARD"));
            card.setId((int) row.get("CARD_ID"));
            card.setX((String) row.get("CARD_X"));
            card.setY((String) row.get("CARD_Y"));

            cards.add(card);
        }
        return cards;
    }

    public Card getUserCard(Integer idUser, Integer idCard){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String selectAllSql = "SELECT * FROM card c LEFT JOIN board b ON c.ID_BOARD=b.BOARD_ID WHERE b.ID_USER = ? AND CARD_ID = ?";
        Card card = new Card();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(selectAllSql,new Object[]{idUser,idCard});
        for (Map row : rows) {
            card.setTitle((String) row.get("CARD_TITLE"));
            card.setColor((String) row.get("CARD_COLOR"));
            card.setId_board((int) row.get("ID_BOARD"));
            card.setId((int) row.get("CARD_ID"));
            card.setX((String) row.get("CARD_X"));
            card.setY((String) row.get("CARD_Y"));
        }
        return card;
    }

    public boolean deleteCard(int idUser, int idCard){
        Card card = getUserCard(idUser, idCard);
        if(card.getId()!=null){
            SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String deleteQuery = "DELETE FROM card WHERE CARD_ID = ?";
            String deleteQuery2 = "DELETE FROM note WHERE ID_CARD = ?";
            getJdbcTemplate().update(deleteQuery,idCard);
            getJdbcTemplate().update(deleteQuery2,idCard);
            return true;
        }

        return false;
    }

    public Map<Integer,ArrayList<Note>> getCardsWithNotes(Integer idboard) {
        HashMap<Integer,ArrayList<Note>> cards = new HashMap<>();

        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String selectAllSql = "SELECT CARD_ID FROM card WHERE ID_BOARD = ?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(selectAllSql, idboard);

        for (Map row : rows) {
            Integer cardId;
            cardId = (int) row.get("CARD_ID");
            String selectAllSql2 = "SELECT * FROM note WHERE ID_CARD = ?";
            List<Map<String, Object>> rows2 = getJdbcTemplate().queryForList(selectAllSql2, cardId);
            ArrayList<Note> notes = new ArrayList<Note>();
            Map<Integer,Object> cardss = null;
            for (Map row2 : rows2) {
                Note note = new Note();
                note.setId((int) row2.get("NOTE_ID"));
                note.setText((String) row2.get("NOTE_TEXT"));
                note.setPosition((int) row2.get("NOTE_POSITION"));

                if(note!=null)
                notes.add(note);
            }
            cards.put(cardId,notes);

        }
        return cards;

    }

    public boolean replaceCard(int i, String x, String y) {
        String updateQuery = "UPDATE card SET CARD_X=?, CARD_Y=? WHERE CARD_ID = ?";
        getJdbcTemplate().update(updateQuery,new Object[]{x,y,i});
        return true;
    }
}
