package com.kent.board.dto;


import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.kent.common.dto.AttachFileDTO;

import lombok.Data;

// VO를 기준으로 만든다. getter, setter가 자유롭다.
@Data
public class BoardDTO {

    private Integer bno;
    @NotEmpty
    @Length(min=5)
    private String title;
    @NotEmpty
    @Length(min=5)
    private String content;
    private String writer;
    String updatedateWord, updatedateStr;
    Date regdate, updatedate;
    
    private Integer replyCount;

    private List<AttachFileDTO> fileList;
}
