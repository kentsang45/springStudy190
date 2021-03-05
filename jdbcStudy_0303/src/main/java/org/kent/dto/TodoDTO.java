package org.kent.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TodoDTO {
	
	private Integer tno;
	
	@NotEmpty
	@Length(min=5, max=10)
	private String title;
	
	private Boolean complete;
	
	
}
