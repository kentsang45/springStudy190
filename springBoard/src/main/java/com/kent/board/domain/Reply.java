package com.kent.board.domain;

import java.sql.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	
	private Integer rno;
	private Integer bno;
	private String reply, replyer;
	private Timestamp replyDate, updateDate;

}
