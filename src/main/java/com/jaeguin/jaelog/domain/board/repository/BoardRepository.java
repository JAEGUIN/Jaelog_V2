package com.jaeguin.jaelog.domain.board.repository;

import com.jaeguin.jaelog.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying
    @Query(value="UPDATE board SET COUNT = count+1 WHERE id = ?1" , nativeQuery = true)
    Integer updateCount(Long id);

    Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

    @Query(value = "SELECT COUNT(*) allContents FROM board ", nativeQuery = true)
    Integer getAllContents();
}
