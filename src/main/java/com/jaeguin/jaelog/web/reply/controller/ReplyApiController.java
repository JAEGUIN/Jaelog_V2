package com.jaeguin.jaelog.web.reply.controller;

import com.jaeguin.jaelog.domain.reply.dto.ReplyWriteDto;
import com.jaeguin.jaelog.domain.reply.entity.Reply;
import com.jaeguin.jaelog.global.config.security.PrincipalDetail;
import com.jaeguin.jaelog.web.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    private final ReplyService replyService;

    @PostMapping("/api/board/{boardId}/reply")
    public void write(@PathVariable Long boardId,
                      @RequestBody ReplyWriteDto replyWriteDto,
                      @AuthenticationPrincipal PrincipalDetail principalDetail) {
        replyService.replyWrite(boardId, replyWriteDto, principalDetail.getUser());
    }

    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public void delete(@PathVariable Long replyId) {
        replyService.replyDelete(replyId);
    }
}
