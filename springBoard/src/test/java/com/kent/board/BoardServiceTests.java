package com.kent.board;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.kent.common.util.DateFormatter;

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
	public void testGetOne() throws Exception {
		BoardDTO board = service.getOne(131073);
		
		show("Board : " + board);
		show("Date : " + board.getUpdatedate());
	}
	
	@Test
	public void testRegister() throws Exception {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("TEST_TITLE");
		dto.setContent("TEST_CONTENT");
		dto.setWriter("TEST_WRITER");
		Integer lastIndex = service.register(dto);
		
		show("Last Index : " + lastIndex);
		show("Board Register Done...");
	}
	
	// 131058
	@Test
	public void testModify()  throws Exception {
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
	
	
	
	
	@Test
	public void testDateFormatter() {
		Date now = new Date();
		Date reg = service.getOne(131077).getUpdatedate(); 
		
		Long nowL = now.getTime();
		Long regL = reg.getTime();
		
		show("NOW : " + now);
		show("REG : " + reg);
		show((regL-nowL)/1000/60/60 + "");
		
		show("WHEN : " + DateFormatter.fromDateToString(reg));
	}
//	                                                                                                                                                                                                           
}
