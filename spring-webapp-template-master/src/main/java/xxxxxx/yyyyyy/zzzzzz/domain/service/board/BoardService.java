package xxxxxx.yyyyyy.zzzzzz.domain.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import xxxxxx.yyyyyy.zzzzzz.domain.model.Board;

import java.util.List;

public class BoardService {

    @Autowired
    private BoardDAO boardDAO;

    public BoardDAO getBoardDAO() {
        return boardDAO;
    }

    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public void addBoard(Board board){
        getBoardDAO().insert(board);
    }
    public List<Board> getUserBoards(Integer userId) {
        return getBoardDAO().selectAll(userId);
    }
    public Board getUserBoard(Integer userId, Integer boardId){return getBoardDAO().getUserBoard(userId,boardId); }

    public void deleteUserBoard(Integer boardId, Integer userId){getBoardDAO().deleteUserBoard(boardId, userId);}

    public void editUserBoard(Integer boardId, Integer id, String name) {
        getBoardDAO().editUserBoard(boardId, id, name);
    }
}
