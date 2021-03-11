package com.kent.board;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kent.AbstractTests;
import com.kent.board.config.BoardConfig;
import com.kent.board.domain.Board;
import com.kent.board.dto.BoardDTO;
import com.kent.board.service.BoardService;
import com.kent.common.dto.PageDTO;

@ContextConfiguration(classes= BoardConfig.class)
public class BoardServiceTests extends AbstractTests{
	
	@Autowired
	BoardService service;
	
	@Test
	public void testTotalCount() {
		PageDTO page = PageDTO.builder().page(0).perSheet(15).type("t").keyword("10").build();
		show("TotalCount : " + service.getTotalCount(page));
	}
	
	@Test
	public void testGetOne() {
		show("Board : " + service.getOne(10));
	}
	
	@Test
	public void testRegister() {
		Board board = Board.builder().title("TEST_TITLE").content("TEST_CONTENT").writer("TEST_WRITER").build();
		service.register(service.toDTO(board));
		show("Board Register Done...");
	}
	
	// 131058
	@Test
	public void testModify() {
		Board board = Board.builder().bno(131059).title("MOD_TITLE").content("MOD_CONTENT").writer("MOD_WRITER").build();
		service.modify(service.toDTO(board));
		show("Board : " + service.getOne(131059));
		show("Board Modify Done...");		
	}
	
	@Test
	public void testDelete() {
		service.delete(131059);
		show("Board : " + service.getOne(131059));
		show("Board Delete Done...");		
	}

	@Test
	public void testPageList() {
		PageDTO page = PageDTO.builder().page(0).perSheet(15).type("t").keyword("100").build();
		List<BoardDTO> list = service.getPageList(page);
		list.forEach(b->show(b));
		show("Board PageList Done...");
	}
//	                                                                                                                                                                                                           
}
