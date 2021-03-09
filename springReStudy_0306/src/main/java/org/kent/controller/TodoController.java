package org.kent.controller;

import org.kent.dto.TodoDTO;
import org.kent.entity.Todo;
import org.kent.mapper.TimeMapper;
import org.kent.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoMapper todoMapper;
	
	@GetMapping("/add")
	public void getAdd(Model model) {
		log.info("======== GET ADD : "+todoMapper+" ========");		
	}
	
	@PostMapping("/add")
	public String postAdd(TodoDTO dto) {
		log.info("======== POST ADD : "+dto+" ========");	
		
		// DTO를 Entity로 옮기기
		Todo todo = Todo.builder().title(dto.getTitle()).complete(dto.getComplete()).build(); 
		
		todoMapper.insert(todo);
		
		return "redirect:/todo/list";
	}
	
	@GetMapping("/list")
	public void getList(Model model) {
		log.info("======== GET LIST : "+todoMapper+" ========");
		model.addAttribute("todo", todoMapper.selectOne(10));	
	}
	
	
}
