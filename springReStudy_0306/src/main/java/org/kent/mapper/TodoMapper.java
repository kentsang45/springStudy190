package org.kent.mapper;

import org.kent.entity.Todo;

public interface TodoMapper {
	Todo selectOne(int tno);
	void insert(Todo todo);
}
