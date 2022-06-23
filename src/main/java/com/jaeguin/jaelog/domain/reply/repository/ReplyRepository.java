package com.jaeguin.jaelog.domain.reply.repository;

import com.jaeguin.jaelog.domain.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
