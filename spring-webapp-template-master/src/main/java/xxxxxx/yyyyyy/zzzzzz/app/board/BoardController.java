package xxxxxx.yyyyyy.zzzzzz.app.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Card;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Note;
import xxxxxx.yyyyyy.zzzzzz.domain.service.board.BoardService;
import xxxxxx.yyyyyy.zzzzzz.domain.service.card.CardService;
import xxxxxx.yyyyyy.zzzzzz.domain.service.note.NoteService;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;


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
            model.addAttribute("boardname",board.getName());
            model.addAttribute("boardid",board.getId());
            CardService cardService = (CardService) context.getBean("cardService");
            ArrayList<Card> cards = cardService.getCards(Integer.valueOf(id_board));
            model.addAttribute("cards", cards);

            Map<Integer,ArrayList<Note>> cardsWithNotes = cardService.getCardsWithNotes(Integer.valueOf(id_board));
            model.addAttribute("cardswithnotes", cardsWithNotes);

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

    @RequestMapping(value = "/delete_card")
    public String deleteCard(Model model, HttpServletRequest request, @RequestParam("id") String cardId){
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String username = userService.getCurrentUserName();
        Integer id = userService.getUserIdByName(username);
        CardService cardService = (CardService) context.getBean("cardService");
        boolean success = cardService.deleteCard(id,Integer.parseInt(cardId));
        if(!success){
            model.addAttribute("error","Próbujesz usunąć nie swoją kartkę!!!");
        }
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public String addNote(Model model, HttpServletRequest request, @RequestParam("cardId") String cardId, @RequestParam("note") String note){
        NoteService noteService = (NoteService) context.getBean("noteService");
        Note newNote = new Note();
        newNote.setId_card(Integer.parseInt(cardId));
        newNote.setText(note);
        noteService.addNote(Integer.parseInt(cardId), newNote);

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/deleteNote", method = RequestMethod.GET)
    public String deleteNote(Model model, HttpServletRequest request, @RequestParam("id") String noteId){
        NoteService noteService = (NoteService) context.getBean("noteService");
        noteService.deleteNote(Integer.parseInt(noteId));

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/replace", method = RequestMethod.GET)
    public String replace(Model model, HttpServletRequest request, @RequestParam("id") String noteId, @RequestParam("x") String x, @RequestParam("y") String y){
        CardService cardService = (CardService) context.getBean("cardService");
        cardService.replaceCard(Integer.parseInt(noteId),x,y);

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

}
