package com.kent.board.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

// VO를 기준으로 만든다. getter, setter가 자유롭다.
@Data
public class BoardDTO {

    private Integer bno;
    @NotEmpty
    @Length(min=10)
    private String title;
    @NotEmpty
    @Length(min=10)
    private String content;
    @NotEmpty
    private String    writer;
    private Date regdate, updatedate;

}
