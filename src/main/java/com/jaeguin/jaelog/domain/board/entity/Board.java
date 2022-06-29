package com.jaeguin.jaelog.domain.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jaeguin.jaelog.domain.base.BaseEntity;
import com.jaeguin.jaelog.domain.reply.entity.Reply;
import com.jaeguin.jaelog.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    private int count; //조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OrderBy("id desc")                 //Cascade.REMOVE설정의 경우 기존의 자식객체는 DB에서 삭제되지 않는다.
    @JsonIgnoreProperties({"board"}) //reply안에서 또 호출을 할때 무시해 주는 기능 -> json으로 파싱 NO (무한참조 방지)
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Reply> replyList;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
