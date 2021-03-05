package org.vertigo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vertigo.domain.SampleDTO;
import org.vertigo.mapper.SampleDAO;

import lombok.extern.log4j.Log4j;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleDAOTests {

	@Autowired
	SampleDAO dao;
	
	@Test
	public void testSampleDAO() {
		log.info(dao);

		log.info("TEST");
		log.info(dao.getOne(3));
		log.info("TEST DONE");
	}
}

