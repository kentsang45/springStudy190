package org.kent.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactory ssf;
	
	@Test
	public void testConnection() {
		try(Connection con = ds.getConnection();) {
			log.info(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}			
	}
	
	@Test
	public void testSSF() {
		try(SqlSession session = ssf.openSession();){
			log.info(session);
			} catch(Exception e ) {
				fail(e.getMessage());
			}
	}
	
}
