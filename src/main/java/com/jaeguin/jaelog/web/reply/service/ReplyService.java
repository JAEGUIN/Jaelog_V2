package com.jaeguin.jaelog.web.reply.service;

import com.jaeguin.jaelog.domain.board.entity.Board;
import com.jaeguin.jaelog.domain.board.repository.BoardRepository;
import com.jaeguin.jaelog.domain.reply.dto.ReplyWriteDto;
import com.jaeguin.jaelog.domain.reply.entity.Reply;
import com.jaeguin.jaelog.domain.reply.repository.ReplyRepository;
import com.jaeguin.jaelog.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void replyWrite(Long boardId, ReplyWriteDto replyWriteDto, User user) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new IllegalArgumentException("해당 boardId가 없습니다. id=" + boardId));
        Reply reply = new Reply();
        reply.write(replyWriteDto.getContent(), board, user);
        replyRepository.save(reply);
    }

    @Transactional
    public void replyDelete(Long id) {
        replyRepository.deleteById(id);
    }
}
