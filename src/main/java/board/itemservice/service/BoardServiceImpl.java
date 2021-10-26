package board.itemservice.service;

import board.itemservice.dto.BoardVO;
import board.itemservice.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardVO> getItemAll() {
        return boardMapper.getItemAll();
    }

    @Override
    public BoardVO getItem(int num) {
        return boardMapper.getItem(num);
    }

    @Override
    public BoardVO addItem(BoardVO boardVO) {
        boardMapper.addItem(boardVO);
        return boardMapper.getItem(boardVO.getNum());
    }

    @Override
    public BoardVO updateBoard(BoardVO boardVO) {
        boardMapper.updateBoard(boardVO);
        return boardMapper.getItem(boardVO.getNum());
    }
}
