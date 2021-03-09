package org.kent.board.dto;

import java.sql.Date;

import lombok.Data;

// VO를 기준으로 만든다. getter, setter가 자유롭다.
@Data
public class BoardDTO {

	private Integer bno;
	private String title, content, writer;
	private Date regdate, updatedate;
	
}
