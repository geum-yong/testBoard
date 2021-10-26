package board.itemservice.service;

import board.itemservice.dto.BoardVO;

import java.util.List;

public interface BoardService {
    List<BoardVO> getItemAll();
    BoardVO getItem(int num);
    BoardVO addItem(BoardVO boardVO);
    BoardVO updateBoard(BoardVO boardVO);
}
