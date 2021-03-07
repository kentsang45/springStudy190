package org.kent.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {
	Integer tno;
	String title;
	Boolean complete;
	Date regdate;
}
