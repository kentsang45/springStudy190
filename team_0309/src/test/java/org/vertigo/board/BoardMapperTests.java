package org.vertigo.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vertigo.board.config.BoardConfig;
import org.vertigo.board.domain.BoardVO;
import org.vertigo.board.dto.BoardDTO;
import org.vertigo.board.mapper.BoardMapper;
import org.vertigo.board.service.BoardService;
import org.vertigo.common.config.RootConfig;
import org.vertigo.common.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, BoardConfig.class})
@Log4j
public class BoardMapperTests {

	@Autowired
	BoardMapper boardMapper;
	@Autowired
	BoardService boardService;
	
	@Test
	public void testTotalCount() {
		int totalCount = boardMapper.getTotalCount();
		log.info("totalCount : " + totalCount);
	}
	
	@Test
	public void testGetList() {
		List<BoardVO> list = boardMapper.getList(0, 20);
		list.forEach(
				l->{ log.info(l.getBno()); }
				);
	}
	
	
	// ====== SERVICE TEST =======//
	// ====== SERVICE TEST =======//
	// ====== SERVICE TEST =======//
	@Test
	public void testServiceGetList() {
		PageDTO page = 
				PageDTO.builder().page(2).perSheet(15).build();
		
		List<BoardDTO> list = boardService.getPageList(page);
		list.forEach(
				l->{ log.info(l); }
				);
	}
	
	@Test
	public void testServiceTotalCount() {
		int totalCount = boardService.getTotalCount();
		log.info("totalCount : " + totalCount);
	}
	
	@Test
	public void testServiceRegister() {
		BoardDTO dto = new BoardDTO(); 
		dto.setTitle("JUNIT 타이틀");
		dto.setWriter("JUNIT 저자");
		dto.setContent("JUNIT 내용");
		
		boardService.register(dto);
		
		log.info("register done ============");
	}
}
