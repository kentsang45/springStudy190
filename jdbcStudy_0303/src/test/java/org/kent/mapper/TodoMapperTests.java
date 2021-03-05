package org.kent.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests{
	
	// 이걸 generic으로 빼내보기!
	@Autowired
	TodoMapper mapper;
	
	@Test
	public void testInsert() {
		log.info("testInsert.............." + mapper);
		
		IntStream.rangeClosed(1, 100).forEach(i->{
			Todo todo = Todo.builder().title("TestTitle" + i).build();
			log.info(todo);
			mapper.insert(todo);
		});
		
		log.info("testInsert.............. done");
	}
	
}
