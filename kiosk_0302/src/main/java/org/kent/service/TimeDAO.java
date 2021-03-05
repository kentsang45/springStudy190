package org.kent.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class TimeDAO {

	private static final String driverName = "oracle.jdbc.driver.OracleDriver";
	private static final String jdbcURL = "jdbc:oracle:thin:@112.169.196.210:1526:XE";
	private static final String userName = "gyus";
	private static final String userPW = "gyus";
	
	public String getTime() throws Exception{
		String sql = "select sysdate from dual";
		
		Class.forName(driverName);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result="";
		try {
			
			con = DriverManager.getConnection(jdbcURL, userName, userPW);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			rs.next();
			result = rs.getString(1);
			System.out.println("result : " + result);
		}catch(Exception e) {
			e.printStackTrace();
			return result;
			
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		
		return result;
		
	}
	
	
}
