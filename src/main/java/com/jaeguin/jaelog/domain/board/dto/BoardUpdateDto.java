package com.jaeguin.jaelog.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class BoardUpdateDto {
    private String title;
    private String content;
}
