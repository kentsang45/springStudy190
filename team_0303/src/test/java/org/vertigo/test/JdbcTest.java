package org.vertigo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTest {

	@Test
	public void testConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");   //JDBC 드라이버 추가해서 연결

		log.info("__________1_________________________");
		
		
		String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC";
		String username = "vertigo";
		String password = "vertigo";
		
		Connection con = DriverManager.getConnection(url, username, password);
		log.info("__________2_________________________");
		
		Statement stmt = con.createStatement(); // 쿼리를 만들러가는 소켓...
		String sql = "select * from tbl_test";
		ResultSet rs = stmt.executeQuery(sql);  // 쿼리(sql)를 실행...
		
		rs.next();     // row 
//		log.info(rs.getString(1 ));   // col
		log.info(rs.getString(2 ));
//		log.info(rs.getString(3 ));
		

		rs.next();                   
//		log.info(rs.getString(1 ));
		log.info(rs.getString(2 ));
//		log.info(rs.getString(3 ));

		con.close();
		
	
	}
	
	
	
	
	
	
	
	
	
}
