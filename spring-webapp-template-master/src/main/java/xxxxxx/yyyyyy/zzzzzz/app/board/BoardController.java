package xxxxxx.yyyyyy.zzzzzz.app.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;
import xxxxxx.yyyyyy.zzzzzz.domain.service.board.BoardService;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl;


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
            model.addAttribute("error","Nie posiadasz takiej tablicy");
        }else{
            model.addAttribute("board",board);
        }
    return "board/board";
    }

}
