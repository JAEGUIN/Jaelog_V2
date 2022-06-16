package com.jaeguin.jaelog.web.board.controller;

import com.jaeguin.jaelog.domain.board.entity.Board;
import com.jaeguin.jaelog.web.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String list(Model model, @PageableDefault(size = 4, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String search) {
        Page<Board> boards = boardService.findByTitleContainingOrContentContaining(search, search, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "board/listForm";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.detail(id));
        boardService.updateCount(id);
        return "board/detailForm";
    }

    @GetMapping("/board/write")
    public String write(){
        return "board/writeForm";
    }

    @GetMapping("/board/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "board/updateForm";
    }

}
