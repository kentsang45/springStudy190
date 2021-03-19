package org.vertigo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		, "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class SecurityTests {
	
	@Autowired
	private PasswordEncoder pe;
	
	@Test
	public void testencoder() {
		log.info("----pe-----"+pe);
	}
	
	@Test
	public void testvertigo() {
		//$2a$10$D88UI7LSh6eH6XpyP0HYTeje2h8bIJW5r/3C61ymhojc1300XirDO
		
		String pw =  "vertigo";
		
		String pepw = pe.encode(pw);//  pw를 인코더로 넣어라
		
		log.info("---안녕...----- " + pepw);
		
	}
	
	@Test
	public void  testvertigobye() {
		
		log.info("----ㅠㅠㅠ-----ㅠㅠㅠ---ㅠ--..--" + pe.matches("vertigo", "$2a$10$D88UI7LSh6eH6XpyP0HYTeje2h8bIJW5r/3C61ymhojc1300XirDO"));
		

	}

}
