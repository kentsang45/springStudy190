package org.gyus.mapper;

import org.gyus.entity.Todo;

public interface TodoMapper {

	
	//메소드만 있고, 몸체는 없다. 인터페이스
	
	
	String getTitle();
	
	void insert(Todo todo);
}
