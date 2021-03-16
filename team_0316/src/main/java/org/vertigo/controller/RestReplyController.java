package org.vertigo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vertigo.domain.ReplyDTO;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/replies")
public class RestReplyController {
	// ReplyMapper (서비스여야한다)
	
	
	// {}와 name의 이름이 같아야한다. 인자는 ajax에서 날아온 값을 저장하는 변수
	
	@GetMapping("/pages/{bno}/{page}")
	public void getReplies(@PathVariable(name="bno") Integer bno, 
						   @PathVariable(name="page") Integer page) {
		log.info("bno : " + bno);
		log.info("page : " + page);
		
		
		
	}
	
	// 등록하기
	@PostMapping(produces = "text/plain")
	public ResponseEntity<String> registerReply(@RequestBody ReplyDTO dto) {
		log.info("============ registerReply ============");
		log.info("page : " + dto);
		
		// mapper로 페이지 만큼의 정보를 가져왔어요
		// List<ReplyDTO> list =  service.getList(PageDTO pageDTO);
		// 보여준다.
		// jsp에 보낼 때 ResponseEntity에 담아서 보낸다.
		// return 
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	// 조회
	@GetMapping("/{rno}")
	public void readRno() {
		
	}
}
