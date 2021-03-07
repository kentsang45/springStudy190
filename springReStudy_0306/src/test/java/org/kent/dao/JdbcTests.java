package org.kent.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTests {	
	@Test
	public void jdbcTest() {		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Driver 연결

			log.info("----------JDBC Connection---------");

			String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC"; // 시간 찍기
			String username = "vertigo";
			String password = "vertigo";
			// 커넥션 연결
			
			con = DriverManager.getConnection(url, username, password);		
			
			log.info("Connection : " + con); // 연결확인
			log.info("----------JDBC Connection Done---------");
		} catch(Exception e) {
			fail(e.getMessage());
		} finally {
			// 커넥션 닫기
			if(con != null) { try { con.close(); } catch(Exception e) { fail(e.getMessage()); } }
		}
	}
}
