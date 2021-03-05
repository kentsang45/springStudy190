package org.gyus.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTests {

	@Test
	public void testConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver"); //Driver 연결

		log.info("----------JDBC Connection---------");

			String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC"; // 시간 찍기
			String username = "vertigo";
			String password = "vertigo";
			
			Connection con = DriverManager.getConnection(url, username, password);
			// 커넥션 연결
			
			log.info(con); // 연결확인
			
			con.close(); // 커넥션 닫기
			
										
	}
}
