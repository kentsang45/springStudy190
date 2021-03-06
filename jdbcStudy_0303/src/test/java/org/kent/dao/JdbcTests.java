package org.kent.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTests {
	
	@Test
	public void testConnection() throws Exception {
		
		// com.mysql.cj.jdbc.Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		log.info("------------- LEVEL 1 : jdbc Connection ---------------");
		
		String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC";
		String username = "vertigo";
		String password = "vertigo";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		log.info(con);
		
		con.close();
		
		log.info("------------- LEVEL 2 : HikariCP ---------------");
		
		// 1. XML
		// 2. Java configuration
		
		log.info("------------- LEVEL 3 ---------------");
		log.info("------------- LEVEL 4 ---------------");

		
	}
}
