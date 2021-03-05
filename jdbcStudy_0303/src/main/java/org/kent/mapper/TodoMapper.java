package org.kent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.kent.entity.Todo;

public interface TodoMapper {

	@Insert("insert into tbl_todo (title, complete) values(#{title}, #{complete}) ")
	public void insert(Todo todo);
	
}
