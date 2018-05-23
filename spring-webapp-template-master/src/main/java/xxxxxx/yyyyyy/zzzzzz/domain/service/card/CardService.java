package xxxxxx.yyyyyy.zzzzzz.domain.service.card;

import org.springframework.beans.factory.annotation.Autowired;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Card;

import java.util.ArrayList;

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
}
