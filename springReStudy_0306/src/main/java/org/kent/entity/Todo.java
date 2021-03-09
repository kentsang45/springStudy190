package org.kent.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Todo {
	Integer tno;
	String title;
	Boolean complete;
	Date regdate;
}
