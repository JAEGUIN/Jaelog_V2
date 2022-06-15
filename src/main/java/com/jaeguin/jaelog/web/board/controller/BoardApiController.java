package com.jaeguin.jaelog.web.board.controller;

import com.jaeguin.jaelog.domain.board.dto.BoardUpdateDto;
import com.jaeguin.jaelog.domain.board.dto.BoardWriteDto;
import com.jaeguin.jaelog.global.config.security.PrincipalDetail;
import com.jaeguin.jaelog.web.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board/write")
    public Long write(@RequestBody BoardWriteDto boardWriteDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.write(boardWriteDto, principalDetail.getUser());
    }

    @DeleteMapping("/api/board/delete/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardService.deleteById(id);
        return id;
    }

    @PutMapping("/api/board/update/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardUpdateDto boardUpdateDto){
        return boardService.update(id, boardUpdateDto);
    }
}
