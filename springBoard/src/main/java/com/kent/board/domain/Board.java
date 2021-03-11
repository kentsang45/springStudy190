package com.kent.board.domain;

import lombok.*;

import java.sql.Date;

@ToString
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Board {

    private Integer bno;
    private String title, content, writer;
    private Date regdate, updatedate;

}
