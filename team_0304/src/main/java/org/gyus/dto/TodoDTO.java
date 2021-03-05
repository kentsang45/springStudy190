package org.gyus.dto;

import lombok.Data;

@Data
public class TodoDTO {
	private Integer tno;
	private String title;
	private boolean complete;

	//DAO Data Access Object
	//DTO Data Transfer Object
}
