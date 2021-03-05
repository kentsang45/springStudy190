package org.gyus.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class  JDBCTests {
	
	@Test
	public void testConnection()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		log.info("1--------------------");
		
		String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC";
		String username = "vertigo";
		String password = "vertigo";
		
		Connection con = DriverManager.getConnection(url, username, password);
		log.info("ok!!!" + con);
		log.info("2---------------------");
		
		
		Statement stmt = con.createStatement();
		String sql = "select * from tbl_test";
		ResultSet rs = stmt.executeQuery(sql);
		
		rs.next();
		
		log.info(rs.getString(2));
		
				
		
	}

}
