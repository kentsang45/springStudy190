package org.gyus.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.gyus.dto.TodoDTO;
import org.gyus.entity.Todo;
import org.gyus.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public void view(Model model) {
		log.info("list main page_______________");
		
		// DUMMY DATA 생성
		List<TodoDTO> list = IntStream.rangeClosed(1,10).mapToObj(i->{
			TodoDTO dto = new TodoDTO();
			dto.setTno(i);
			dto.setTitle("SAMPLE_TITLE" + i);
			return dto;
		}).collect(Collectors.toList());
		
		
		// VIEW에 데이터를 넘겨준다.
		// 오브젝트만 넣으면 타입의 앞글자를 소문자로 바꾼다.
		model.addAttribute("list", list);
	}
	
	
	
	@GetMapping({"/add", "/addAjax"})
	public void add() {
		log.info("getAdd~~~~");
	}

	
	@PostMapping("/add")
	public String addPost(TodoDTO dto) {
		log.info("post yeee~~~" + dto);
	
//		Todo todo = Todo.builder()
//				.title(dto.getTitle()) 
//				.complete(dto.isComplete())
//                .build();
		
//		mapper.insert(todo);
		
//		log.info("mapper~~~~~" +mapper);
	
		return "redirect:/todo/list";
	}
	
	
	@PostMapping(value="/addAjax")
	@ResponseBody
	public Object addAjaxPost(@Valid TodoDTO todoDTO, BindingResult br) {
		log.info("===================== POST AJAX =====================" + todoDTO);
	
		// VALIDATION
		if(br.hasErrors()) {
			log.info("========== VALD ERROR ==============("+br+")");
			
			return br.getAllErrors();
		}
			
		return null;
	}
}
