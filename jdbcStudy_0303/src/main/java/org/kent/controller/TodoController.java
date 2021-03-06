package org.kent.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.kent.dto.TodoDTO;
import org.kent.entity.Todo;
import org.kent.mapper.TodoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo") // todo로 들어오는 모든 친구들
@Log4j
@RequiredArgsConstructor
public class TodoController {
	// 입력과 처리가 분리 = GET, POST
	
	private final TodoMapper mapper;
	
	// spring 4버전
	@GetMapping({"/add", "/addTwo", "/addOne"})
	public void add() {
		log.info("get add..................");
		
	}
	
	// BindingResult = 
	// redirection 하는 방법 = String을 반환
	@PostMapping(value="/add")
	public String addPost(@Valid TodoDTO dto, BindingResult br) {
		log.info("post add.....................");
		log.info(dto);
		
		// validation에 실패했다면...
		if(br.hasErrors()) {
			log.info("================ VALIDATION ERROR ("+br+")===============");
			
			// 실패했다면 다시 원래 페이지로 보낸다.
			return "/todo/add";
		}
		
		Todo todo = Todo.builder().title(dto.getTitle()).complete(dto.getComplete()).build(); 
		
		// mapper.insert(todo);

		return "redirect:/todo/list";
		//return "success";
	}
	
	// redirection 하는 방법 = String을 반환
	@PostMapping("/addOne")
	public String addOnePost(TodoDTO dto) {
		log.info("post add1.....................");
		log.info(dto);
		
		Todo todo = Todo.builder().title(dto.getTitle()).complete(dto.getComplete()).build(); 
	
		// mapper.insert(todo);

		return "redirect:/todo/list?msg=success";
	}
	
	//========================= ADD 2 ==========================//
	
	// redirection 하는 방법 = String을 반환
	@PostMapping("/addTwo")
	@ResponseBody
	public Object addTwoPost(@Valid TodoDTO dto, BindingResult br) {
		log.info("post add2.....................");
		log.info(dto);
		
		// validation에 실패했다면...
		if(br.hasErrors()) {
			log.info("================ VALIDATION ERROR 2 ("+br+")===============");
			
			// 실패했다면 다시 원래 페이지로 보낸다.
			// return "/todo/add";
			return br.getAllErrors();
		}
		
		Todo todo = Todo.builder().title(dto.getTitle()).complete(dto.getComplete()).build(); 
		
		return null;
	}
	
	@GetMapping("/list")
	public void list(Model model) 	{
		log.info("get list.....................");
		
		// model에 넣으면 view까지 간다.
		// rangeClosed는 1~10까지 range는 1~9까지 
		// mapToObj는? DTO를 map으로 묶어준다.
		// collect는?
		// Collectors는? map을 List로...
		List<TodoDTO> list = IntStream.rangeClosed(1,10).mapToObj(i->{
			TodoDTO dto = new TodoDTO();
			dto.setTno(i);
			dto.setTitle("SAMPLE_TITLE" + i);
			return dto;
		}).collect(Collectors.toList());
		
		// 오브젝트만 넣으면 타입의 앞글자를 소문자로 바꾼다.
		model.addAttribute("list", list);
	}
	
}
