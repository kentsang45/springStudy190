package org.gyus.test;

import org.gyus.entity.Todo;
import org.gyus.mapper.TodoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {
	
	@Autowired
	TodoMapper todoMapper; 
	
	
	
	@Test
	public void getTitle() {
		log.info(todoMapper.getTitle());
	}
	
	@Test
	public void insert() {
		String le = "mj3";
		Todo todo = Todo.builder().title(le).build();
		todoMapper.insert(todo);
		log.info("insert test done........");
	}
	
}
