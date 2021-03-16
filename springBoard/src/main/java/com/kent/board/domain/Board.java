package com.kent.board.domain;

import java.util.Date;

import lombok.*;


@ToString
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Board {

    private Integer bno;
    private String title, content, writer;
    private Date regdate, updatedate;
    private Integer replyCount;

}
