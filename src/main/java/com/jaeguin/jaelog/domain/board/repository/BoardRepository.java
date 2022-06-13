package com.jaeguin.jaelog.domain.board.repository;

import com.jaeguin.jaelog.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
