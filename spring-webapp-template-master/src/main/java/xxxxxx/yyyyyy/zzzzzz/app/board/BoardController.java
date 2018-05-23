package xxxxxx.yyyyyy.zzzzzz.app.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Card;
import xxxxxx.yyyyyy.zzzzzz.domain.service.board.BoardService;
import xxxxxx.yyyyyy.zzzzzz.domain.service.card.CardService;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl;

import java.util.ArrayList;


@Controller
@RequestMapping("board")
public class BoardController {
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/projectName-env.xml");

    @RequestMapping(value = "")
    public String displayBoard(ModelMap model, @RequestParam("id") String id_board) {
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String username = userService.getCurrentUserName();
        Integer id = userService.getUserIdByName(username);
        BoardService boardService = (BoardService) context.getBean("boardService");
        Board board = boardService.getUserBoard(id, Integer.valueOf(id_board));
        if(board.getId()==null){
            return "redirect:/main";
            //model.addAttribute("error","Nie posiadasz takiej tablicy");
        }else{
            model.addAttribute("board",board);
            CardService cardService = (CardService) context.getBean("cardService");
            ArrayList<Card> cards = cardService.getCards(Integer.valueOf(id_board));
            model.addAttribute("cards", cards);
        }
    return "board/board";
    }

    @RequestMapping(value = "/new_card", params = "createCard", method = RequestMethod.POST)
    public String createBoard(@RequestParam("cardTitle") String title, @RequestParam("cardColor") String color, @RequestParam("boardId") String idBoard) {
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String username = userService.getCurrentUserName();
        Integer id = userService.getUserIdByName(username);
        Card card = new Card();
        card.setTitle(title);
        card.setColor(color);
        card.setId_board(Integer.parseInt(idBoard));

        CardService cardService = (CardService) context.getBean("cardService");
        cardService.addCard(card);

        return "redirect:/board?id="+idBoard;
    }

}
