package com.kent.board.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

// VO를 기준으로 만든다. getter, setter가 자유롭다.
@Data
public class BoardDTO {

    private Integer bno;
    private String title;
    private String         content;
    @NotEmpty
    private String    writer;
    private Date regdate, updatedate;

}
