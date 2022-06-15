package com.jaeguin.jaelog.web.board.controller;

import com.jaeguin.jaelog.web.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String list(Model model){
        model.addAttribute("boardlist", boardService.findAll());
        return "board/listForm";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.detail(id));
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
