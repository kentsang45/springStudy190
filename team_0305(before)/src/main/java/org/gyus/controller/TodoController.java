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
@RequestMapping("/todo") // url
@Log4j
@RequiredArgsConstructor // 생성자
public class TodoController {

	private final TodoMapper mapper;
//	@Autowired
//	TodoMapper todoMapper;

	
	@GetMapping("/list")
	public void view() {
		log.info("list main page_______________");
	}
	
	
	
	@GetMapping("/add")
	public void add() {
		log.info("getAdd~~~~");
	}

	
	@PostMapping("/add")
	public String addPost(TodoDTO dto) {
		log.info("post yeee~~~");
	
//		Todo todo = Todo.builder()
//				.title(dto.getTitle()) 
//				.complete(dto.isComplete())
//                .build();
//		
		
		// mapper.insert(todo);
		log.info("mapper~~~~~" +mapper);
		
		return "redirect:/todo/list";
	}
}
