package org.kent.dto;

import java.util.Date;

import org.kent.entity.Todo;

import lombok.Data;

@Data
public class TodoDTO {
	Integer tno;
	String title;
	Boolean complete;
	Date regdate;
}
