package org.gyus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
	
	private Integer tno;
	private String title;
	private String regdate;
	private boolean complete;

}
