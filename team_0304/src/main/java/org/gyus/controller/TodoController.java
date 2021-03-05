package org.gyus.controller;

import org.gyus.dto.TodoDTO;
import org.gyus.entity.Todo;
import org.gyus.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo")
@Log4j
@RequiredArgsConstructor
public class TodoController {


	private final TodoMapper mapper;

	
	@GetMapping("/add") // 그냥 화면에 보여주는거
	public void add() {
		log.info("get add.............");
	}
	  
	@PostMapping("/add") // 수행되는거
	public String addPost(TodoDTO dto) {
		log.info("post add............");
		log.info(dto);
		
		Todo todo = Todo.builder()
				.title(dto.getTitle())
				.complete(dto.isComplete())
				.build();
		
		mapper.insert(todo);
		
		return "redirect:/todo/list";
	}
	
	

}
