package org.vertigo.board.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vertigo.board.dto.BoardDTO;
import org.vertigo.board.service.BoardService;
import org.vertigo.common.dto.PageDTO;
import org.vertigo.common.dto.PageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
@Log4j
public class BoardController {
	
	private final BoardService boardService;
	
	
	
	// PageDTO는 browser에서 넘어온 정보이다.
	// Model은 view로 넘겨줄 정보이다.
	@GetMapping("/list")
	public String getList(PageDTO pageDTO, Model model) {
		log.info("=========== BOARD CONTROLLER GETLIST ==========");
		
		PageMaker pageMaker = new PageMaker(pageDTO, boardService.getTotalCount());
		
		model.addAttribute("list", boardService.getPageList(pageDTO));
		model.addAttribute("pageMaker", pageMaker);
		
		return "/board/list";
	}
	
	@GetMapping("/register")
	public void getRegister() {
		log.info("=========== BOARD CONTROLLER GET REGISTER ==========");
	}
	
	 @PostMapping(value = "/register", produces= {"text/plain"})
	 @ResponseBody
	 public ResponseEntity registerPost(@RequestBody @Valid BoardDTO boardDTO, BindingResult result){
	    log.info("=================== BOARD CONTROLLER POST REGISTER ===================");
	    log.info(boardDTO);

	    if(result.hasErrors()){
	        log.info(result.getAllErrors());

	            // error의 상세 내용을 어떻게 전달할 수 있을까?
	            // INTERNAL_SERVER_ERROR 는 500 메시지이다.
	            return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        // 등록...

	        // 톰캣에서 만든 메시지를 처리할 수 있다. HttpStatus
	        return new ResponseEntity<String>("success", HttpStatus.OK);
	    }
	
	 @GetMapping("/read")
		public void getRead(int bno, Model model) {
			log.info("=========== BOARD CONTROLLER GET READ ==========");
			BoardDTO dto = boardService.selectOne(bno);
			model.addAttribute("board", dto);
		}
	 
}
