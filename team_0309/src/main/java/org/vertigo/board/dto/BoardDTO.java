package org.vertigo.board.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

// VO를 기준으로 만든다. getter, setter가 자유롭다.
@Data
public class BoardDTO {

    private Integer bno;
    @NotEmpty(message = "제목을 입력하세요.")
    private String title;
    @NotEmpty(message = "내용을 입력하세요.")
    private String content;
    @NotEmpty
    private String    writer;
    private Date regdate, updatedate;

}
