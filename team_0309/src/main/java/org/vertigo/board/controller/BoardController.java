package org.vertigo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vertigo.board.service.BoardService;
import org.vertigo.common.dto.PageDTO;
import org.vertigo.common.dto.PageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
@Log4j
public class BoardController {
	
	private final BoardService boardService;
	
	
	
	// PageDTO는 browser에서 넘어온 정보이다.
	// Model은 view로 넘겨줄 정보이다.
	@GetMapping("/list")
	public String getList(PageDTO pageDTO, Model model) {
		log.info("=========== BOARD CONTROLLER GETLIST ==========");
		
		PageMaker pageMaker = new PageMaker(pageDTO, boardService.getTotalCount());
		
		model.addAttribute("list", boardService.getPageList(pageDTO));
		model.addAttribute("pageMaker", pageMaker);
		
		return "/board/list";
	}
	
}
