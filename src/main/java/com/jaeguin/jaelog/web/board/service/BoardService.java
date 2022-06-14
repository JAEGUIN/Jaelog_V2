package com.jaeguin.jaelog.web.board.service;

import com.jaeguin.jaelog.domain.board.dto.BoardWriteDto;
import com.jaeguin.jaelog.domain.board.entity.Board;
import com.jaeguin.jaelog.domain.board.repository.BoardRepository;
import com.jaeguin.jaelog.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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

    @Transactional(readOnly = true)
    public List<Board> findAll() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Transactional(readOnly = true)
    public Board detail(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
    }
}
