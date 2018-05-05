package xxxxxx.yyyyyy.zzzzzz.app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.service.board.BoardService;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserDAO;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl;
import org.springframework.security.core.userdetails.User;
import java.util.List;

@Controller
@RequestMapping("main")
public class MainController {
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/projectName-env.xml");

    @RequestMapping(value = "")
    public String displayMain(ModelMap model) {
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String username = userService.getCurrentUserName();
        Integer id = userService.getUserIdByName(username);
        BoardService boardService = (BoardService) context.getBean("boardService");
        List<Board> boards = boardService.getUserBoards(id);
        model.addAttribute("boards", boards);
        return "main/main";
    }

    @RequestMapping(value = "/delete")
    public String deleteBoard(ModelMap model, @RequestParam("id") String idBoard) {
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String username = userService.getCurrentUserName();
        Integer id = userService.getUserIdByName(username);
        BoardService boardService = (BoardService) context.getBean("boardService");
        boardService.deleteUserBoard(Integer.valueOf(idBoard),id);
        return "redirect:/main";
    }

    @RequestMapping(value = "/new_board", params = "createBoard", method = RequestMethod.POST)
    public String createBoard(@RequestParam("name") String name, @RequestParam("color") String color) {
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String username = userService.getCurrentUserName();
        Integer id = userService.getUserIdByName(username);
        Board boardNew = new Board();
        boardNew.setName(name);
        boardNew.setColor(color);
        boardNew.setId_user(id);
        BoardService boardService = (BoardService) context.getBean("boardService");
        boardService.addBoard(boardNew);

        return "redirect:/main";
    }

}
