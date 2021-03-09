package org.vertigo.board.domain;

import lombok.*;

import java.sql.Date;

@ToString
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BoardVO {

    private Integer bno;
    private String title, content, writer;
    private Date regdate, updatedate;

}
