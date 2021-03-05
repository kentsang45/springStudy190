package org.gyus.mapper;

import org.gyus.entity.Todo;
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
	TodoMapper todo;
	
	
	@Test
	public void testSelectOne() {
		log.info("ㅠㅠㅠㅠ" + todo);
		log.info("what?!!!!!" + todo.selectOne());
	}


	@Test
	public void testInsert() {
		String a = "ㅜㅇㅜ";
		Todo tt = Todo.builder().title(a).build();
		todo.insert(tt);
		log.info("yee~~~~~");
		

		
		
	}
}
