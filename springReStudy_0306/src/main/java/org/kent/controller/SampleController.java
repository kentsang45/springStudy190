package org.kent.controller;

import org.kent.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	TimeMapper timeMapper;
	
	@GetMapping("/time")
	public void getTime(Model model) {
		log.info("======== GET TIME : "+timeMapper+" ========");
		model.addAttribute("time", timeMapper.getTime());
		
	}
}
