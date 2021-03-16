package org.vertigo.domain;

import java.sql.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
	
	private Integer rno;
	private Integer bno;
	private String reply, replyer;
	private Timestamp replyDate, updateDate;

}
