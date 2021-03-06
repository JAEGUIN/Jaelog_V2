package com.jaeguin.jaelog.domain.reply.entity;

import com.jaeguin.jaelog.domain.base.BaseEntity;
import com.jaeguin.jaelog.domain.board.entity.Board;
import com.jaeguin.jaelog.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public void write(String content, Board board, User user) {
        this.content = content;
        this.board = board;
        this.user = user;
    }

}
