package com.jaeguin.jaelog.web.board.service;

import com.jaeguin.jaelog.domain.board.dto.BoardWriteDto;
import com.jaeguin.jaelog.domain.board.entity.Board;
import com.jaeguin.jaelog.domain.board.repository.BoardRepository;
import com.jaeguin.jaelog.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long write(BoardWriteDto boardWriteDto, User user){
        boardWriteDto.setUser(user);
        return boardRepository.save(boardWriteDto.toEntity()).getId();
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

}
