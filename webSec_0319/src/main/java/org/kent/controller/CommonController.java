package org.kent.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("Hello, ACCESS ERROR!");
	}
	
	@GetMapping("/customLogin")
	public void loginPage(String error, String logout, Model model) {
		log.info("Error : " +error);
		log.info("logout : " +logout);
		
		if(null != logout) {
			model.addAttribute("logout", "로그 아웃되었습니다.");
		}
		
			
	}
	
	@GetMapping("/customLogout")
	public void logoutPage() {
		
	}
	
}
