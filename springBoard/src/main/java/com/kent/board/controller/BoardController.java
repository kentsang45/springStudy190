package com.kent.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kent.board.dto.BoardDTO;
import com.kent.board.service.BoardService;
import com.kent.common.dto.PageDTO;
import com.kent.common.dto.PageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/list")
	public void getList(PageDTO page, Model model) {
		log.info("===== BOARD CONTROLLER : getList =====");
		PageMaker pageMaker = new PageMaker(page, boardService.getTotalCount(page)); 
		List<BoardDTO> boardList = boardService.getPageList(page);
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", boardList);
	}
	
	@GetMapping("/register")
	public void getRegister() {
		log.info("===== BOARD CONTROLLER : getRegister =====");
	}
	
	@GetMapping("/view")
	public void getView() {
		log.info("===== BOARD CONTROLLER : getView =====");
	}
	
	@GetMapping("/modify")
	public void getModify() {
		log.info("===== BOARD CONTROLLER : getModify =====");
	}
	
	
	
	
	
}
