package org.gyus.mapper;

import org.gyus.entity.Todo;

public interface TodoMapper {
	
	String selectOne();
	
	void insert(Todo todo);
}
