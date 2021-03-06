package org.gyus.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AcademyTests {
	
	@Autowired
	private Academy academy;
	
	@Test
	public void testExist() {
		
		assertNotNull(academy);
		System.out.println(academy);
		System.out.println(academy.getTeacher());
		
	}
	
	
	

}
