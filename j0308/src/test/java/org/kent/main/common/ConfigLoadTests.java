package org.kent.main.common;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.common.config.CommonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommonConfig.class})
public class ConfigLoadTests {

	
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory ssf;
	
	// root-config.xml 말고 java에 설정 정보를 넣은 것이다.
	// java class 에 저장한다. 그 클래스는 바로... CommonConfig 이다.
	@Test
	public void CommonConfigTest() {
		log.info("================= CommonConfigTest ====================");
	}
	
	
	@Test
	public void testDataSource() {
		log.info("================= testDataSource ====================");
		log.info("================= ds : "+ds+" ====================");
		assertNotNull(ds);
	}
	
	@Test
	public void testSqlSessionFactory() {
		// java.lang.IllegalStateException: Failed to load ApplicationContext 에러가 발생한다면
		// spring-jdbc를 pom.xml에 추가해야한다.
		
		log.info("================= testSqlSessionFactory ====================");
		
		try(SqlSession session = ssf.openSession()){
			log.info("================= testSqlSessionFactory : "+session+" ====================");
			assertNotNull(ssf);
		}catch(Exception e) {
			log.info(e.getMessage());
		}
		
		log.info("================= testSqlSessionFactory Done ====================");
	}
}
