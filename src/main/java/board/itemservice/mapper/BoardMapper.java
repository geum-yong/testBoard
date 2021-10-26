package board.itemservice.mapper;

import board.itemservice.dto.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVO> getItemAll();
    BoardVO getItem(@Param("num") int num);
    void addItem(BoardVO boardVO);
    void updateBoard(BoardVO boardVO);
}
