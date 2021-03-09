package org.kent.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@GetMapping({"/", "/list"})
	public String getList(){
		// /board, /board/list 둘다 list로 왔으면 좋겠다.
		log.info("============== BOARD CONTROLLER GETLIST ================");
		return "/board/list";
	}
}
