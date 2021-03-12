package com.kent.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/test")
	public void getTest() {
	}

	@GetMapping("/list")
	public void getList(PageDTO page, Model model) {
		log.info("===== BOARD CONTROLLER : getList =====");
		PageMaker pageMaker = new PageMaker(page, boardService.getTotalCount(page));
		List<BoardDTO> boardList = boardService.getPageList(page);

		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", boardList);
	}

	// =========== REGISTER ==============

	@GetMapping("/register")
	public void getRegister(PageDTO pageDTO, Model model) {
		log.info("===== BOARD CONTROLLER : getRegister =====");
		PageMaker pageMaker = new PageMaker(pageDTO, boardService.getTotalCount(pageDTO));
		model.addAttribute("pageMaker", pageMaker);
	}

	@PostMapping(value = "/register", produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<Map<String, String>> postRegister(PageDTO pageDTO, @Valid @RequestBody BoardDTO boardDTO,
			BindingResult result) {
		log.info("============== BOARD CONTROLLER : postRegister =================");
		Map<String, String> messageMap = new HashMap();

		log.info("boardDTO: " + boardDTO);

		if (result.hasErrors()) {
			log.info("====================ERROR===================");

			messageMap.put("result", "fail");
			messageMap.put("message", validationCheck(result));

			return new ResponseEntity(messageMap, HttpStatus.OK);
		}
		
		try {
			boardService.register(boardDTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		messageMap.put("result", "success");

		// 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.

		return new ResponseEntity(messageMap, HttpStatus.OK);
	}

	// =========== VIEW ==============

	@GetMapping("/view")
	public void getView(BoardDTO dto, PageDTO page, Model model) {
		log.info("===== BOARD CONTROLLER : getView =====");
		int bno = dto.getBno();
		model.addAttribute("pageDTO", page);
		model.addAttribute("board", boardService.getOne(bno));
	}

	// =========== MODIFY ==============

	@GetMapping("/modify")
	public void getModify(PageDTO page, BoardDTO dto, Model model) {
		log.info("===== BOARD CONTROLLER : getModify =====");
		int bno = dto.getBno();
		model.addAttribute("pageDTO", page);
		model.addAttribute("board", boardService.getOne(bno));
	}

	@PostMapping(value = "/modify", produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<Map<String, String>> postModify(PageDTO pageDTO, @Valid @RequestBody BoardDTO boardDTO, BindingResult result) {
		log.info("============== BOARD CONTROLLER : postModify =================");
		log.info(boardDTO);

		Map<String, String> messageMap = new HashMap();
		
		if (result.hasErrors()) {
			log.info("====================ERROR===================");

			messageMap.put("result", "fail");
			messageMap.put("message", validationCheck(result));

			return new ResponseEntity(messageMap, HttpStatus.OK);
		}
		
		try {
			boardService.modify(boardDTO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		messageMap.put("result", "success");

		return new ResponseEntity(messageMap, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<Map<String, String>> postDelete(@RequestBody BoardDTO boardDTO) {
		log.info("============== BOARD CONTROLLER : deleteModify =================");
		log.info(boardDTO);

		boardService.delete(boardDTO.getBno());

		Map<String, String> messageMap = new HashMap();
		messageMap.put("result", "success");

		return new ResponseEntity(messageMap, HttpStatus.OK);
	}

	//==============================
	// VALIDATION CHECK
	//==============================	
	private String validationCheck(BindingResult result) {
		// result.getAllErrors().forEach(e->{ log.info(e.getDefaultMessage()); });
		String errorCode = result.getAllErrors().get(0).getCode();
		log.info("boardDTO : " + result.getAllErrors().get(0).toString());

		int titleError = result.getAllErrors().get(0).toString().indexOf("title");

		String errorValue = titleError == -1 ? "내용" : "제목";
		String errorMessage = "";

		switch (errorCode) {
		case "Length":
			errorMessage = errorValue + "을 5자 이상 적어야 합니다.";
			break;
		case "NotEmpty":
			errorMessage = errorValue + "을 적어 주세요.";
			break;
		}
		
		return errorMessage;
	}

}
