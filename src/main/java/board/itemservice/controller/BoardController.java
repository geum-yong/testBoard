package board.itemservice.controller;

import board.itemservice.dto.BoardVO;
import board.itemservice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String board(Model model) {
        List<BoardVO> list = boardService.getItemAll();
        model.addAttribute("list", list);

        return "home";
    }

    @GetMapping("/{itemNum}")
    public String item(@PathVariable int itemNum, Model model) {
        BoardVO item =  boardService.getItem(itemNum);
        model.addAttribute("item", item);

        return "item";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String add(BoardVO boardVO, RedirectAttributes redirectAttributes) {
        BoardVO item = boardService.addItem(boardVO);
        redirectAttributes.addAttribute("itemNum", item.getNum());

        return "redirect:/{itemNum}";
    }

    @GetMapping("/{itemNum}/edit")
    public String edit(@PathVariable int itemNum, Model model) {
        BoardVO item = boardService.getItem(itemNum);
        model.addAttribute("item", item);

        return "modify";
    }

    @PostMapping("/{itemNum}/edit")
    public String edit(@PathVariable int itemNum, BoardVO boardVO, RedirectAttributes redirectAttributes) {
        boardVO.setNum(itemNum);
        BoardVO item = boardService.updateBoard(boardVO);
        redirectAttributes.addAttribute("itemNum", item.getNum());

        return "redirect:/{itemNum}";
    }
}
