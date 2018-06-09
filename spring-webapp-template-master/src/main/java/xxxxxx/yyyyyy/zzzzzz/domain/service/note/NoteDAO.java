package xxxxxx.yyyyyy.zzzzzz.domain.service.note;

import org.aspectj.weaver.Position;
import org.aspectj.weaver.ast.Not;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Note;

import java.util.Date;

public class NoteDAO {
    @Autowired
    private JdbcTemplate jdbctemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbctemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }


    public boolean addNote(int i, Note note) {
        String sqlinsert ="INSERT INTO `note` (`NOTE_TEXT`, `NOTE_STYLE`, `NOTE_POSITION`, `ID_CARD`, `CREATED_AT`, `UPDATED_AT`)"
                + " VALUES (?, ?, ? , ?, ?, ?)";
        String text = note.getText();
        Integer cardId = note.getId_card();
        Date date = DateTime.now().toDate();
        int position = 0;

        getJdbcTemplate().update(sqlinsert,new Object[]{text,"", position, cardId,date ,date});
        return true;
    }

    public boolean deleteNote(int idNote) {
        String deleteQuery2 = "DELETE FROM note WHERE NOTE_ID = ?";
        getJdbcTemplate().update(deleteQuery2,idNote);

        return true;
    }

}
