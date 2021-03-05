package org.gyus.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
	
	private Integer tno;
	
	@NotEmpty
	@Length(min=5, max=10)
	private String title;
	
	private boolean complete;
	private String regdate;

}
