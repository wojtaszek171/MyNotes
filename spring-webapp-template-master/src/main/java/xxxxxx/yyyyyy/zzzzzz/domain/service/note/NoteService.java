package xxxxxx.yyyyyy.zzzzzz.domain.service.note;

import org.springframework.beans.factory.annotation.Autowired;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Note;

public class NoteService {
    @Autowired
    private NoteDAO noteDAO;

    public NoteDAO getCardDAO() {
        return noteDAO;
    }

    public void setCardDAO(NoteDAO cardDAO) {
        this.noteDAO = cardDAO;
    }


    public boolean addNote(int i, Note note) {
        return getCardDAO().addNote(i, note);
    }
}
