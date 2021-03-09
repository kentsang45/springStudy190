package org.kent.board.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
