package org.kent.security;

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
	private PasswordEncoder pwEncoder;
	
	@Test
	public void testEncoder() {
		log.info("ENCODER : " + pwEncoder);
	}
	
	@Test
	public void testMember() {
		String pw = "member";
		
		String enPw = pwEncoder.encode(pw);
		
		log.info("ENPW : " + enPw);
	}
	
	@Test
	public void testMatch(){
		String key = "$2a$10$DrcATdp105jiHIP6fcUxSOHQHRuCBO2gcI3yw2dTsL8wqV26EjEd.";
		
		Boolean result = pwEncoder.matches("member", key);
		
		log.info(result);
	}
	
}
