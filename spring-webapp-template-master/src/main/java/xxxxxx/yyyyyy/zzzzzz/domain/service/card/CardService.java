package xxxxxx.yyyyyy.zzzzzz.domain.service.card;

import org.springframework.beans.factory.annotation.Autowired;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Card;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Note;

import java.util.ArrayList;
import java.util.Map;

public class CardService {
    @Autowired
    private CardDAO cardDAO;

    public CardDAO getCardDAO() {
        return cardDAO;
    }

    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public void addCard(Card card){
        getCardDAO().insert(card);
    }

    public ArrayList<Card> getCards(int idBoard) {return getCardDAO().getCards(idBoard);}

    public boolean deleteCard(int idUser, int idCard) {return getCardDAO().deleteCard(idUser,idCard);}

    public Map<Integer,ArrayList<Note>> getCardsWithNotes(Integer integer) {
        return getCardDAO().getCardsWithNotes(integer);
    }

    public boolean replaceCard(int i, String x, String y) {
        return getCardDAO().replaceCard(i,x,y);
    }
}
