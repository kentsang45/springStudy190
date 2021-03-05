package org.kent.controller;

import org.kent.mapper.TimeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jdk.internal.org.jline.utils.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

// bean 등록 된다
@Controller
@Log4j
@RequestMapping("/sample")
public class SampleController {
	
	private final TimeMapper timeMapper;
	
	public SampleController(TimeMapper timeMapper) {
		this.timeMapper = timeMapper;
	}
	
	
	// /sample/doA 의 url이 된다
	@RequestMapping("/doA")
	public void doA(Model model) {
		log.info("====== doA =======");
		String now = timeMapper.getTime2();
		log.info(now);
		
		// model에 정보를 담으면 view로 전달 가능하다.
		// model.addAttribute("time", now); // == request.setAttribute(...);
	}
}
