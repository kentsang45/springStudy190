package org.kent.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	ReplyMapper mapper;
	
	// 131092
	// 131081
	@Test
	public void testReply() {
		log.info("--mapper--" + mapper);
		
		int bno = 131092;
		
		for (int i = 0;  i< 15 ; i++ ) {
			ReplyVO vo = ReplyVO.builder().reply("TEST" +i).replyer("user " +i).bno(bno).build();
			
			mapper.insert(vo);
			
		}
	}
	
	@Test
	public void testSelect() {
		log.info("---------------testSelect----------" + mapper);
		log.info(mapper.selectOne(10));
	}
	
	@Test
	public void testUpdate() {
		int bno = 131092;
		log.info("---------------testUpdate----------" + mapper);
		ReplyVO vo = ReplyVO.builder().reply("TEST" +15).replyer("user" +15).rno(10).build();
		mapper.update(vo);
		log.info("---------------testUpdate done----------" + mapper);
	}
	
	@Test
	public void testDelete() {
		log.info("---------------testDelete----------" + mapper);
		mapper.delete(10);
		log.info("---------------testDelete done----------" + mapper);
	}
	
	@Test
	public void testList() {
		int bno = 131092;
		mapper.selectList(bno, 0).forEach(r-> log.info(r));
	}
	//limit 에서는 연산 할 수 없음

}
