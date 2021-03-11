package com.kent.common;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kent.common.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class ConfigLoadTests {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactory ssf;
	
	@Test
	public void testConfig() {
		log.info("testConfig");
	}
	
	@Test
	public void testDataSource() {
		log.info("DS : " + ds);
	}
	
	@Test
	public void testSqlSession() {
		log.info("SSF : " + ssf);
		try(SqlSession session = ssf.openSession();){ 
		log.info("SqlSession : " + session);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		log.info("testSqlSession DONE");
	}
	
	
}
