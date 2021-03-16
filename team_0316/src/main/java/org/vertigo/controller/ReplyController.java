package org.vertigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/replies")
@Log4j
public class ReplyController {
	
	@GetMapping
	public void getList() {
		log.info("================ GET LIST =================");
	}
}
