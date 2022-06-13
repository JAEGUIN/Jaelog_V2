package com.jaeguin.jaelog.web.board.controller;

import com.jaeguin.jaelog.web.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String list(){
        return "board/listForm";
    }

}
