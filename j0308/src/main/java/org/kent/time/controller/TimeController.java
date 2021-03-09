package org.kent.time.controller;

import org.kent.time.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/time")
@RequiredArgsConstructor
@Log4j
public class TimeController {
	
	private final TimeService service;
	
	@GetMapping("/now")
	public void getNow(Model model) {
		log.info("============= TimeController getNow() ============");
		log.info(service.getTime());
		
		model.addAttribute("time", service.getTime());
	}
	
}
