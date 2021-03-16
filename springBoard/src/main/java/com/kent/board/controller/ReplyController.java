package com.kent.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kent.board.dto.ReplyDTO;
import com.kent.board.service.ReplyService;
import com.kent.common.dto.PageDTO;
import com.kent.common.dto.PageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
@Log4j
public class ReplyController {

	private final ReplyService service;
	
//	// 댓글 수정
//	@PutMapping("/{rno}")
//	public ResponseEntity<SampleDTO> modifySample(@RequestBody SampleDTO dto){
//		log.info("============ modify sample ===============");
//		log.info("DTO : " + dto);
//		
//		
//		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
//	}
//	
//	// 댓글 삭제
//	@DeleteMapping("/{sno}")
//	public ResponseEntity<Boolean> deleteSample(@PathVariable(name="sno") Integer sno ){
//		log.info("============ delete sample ===============");
//		log.info("SNO : " + sno);
//		
//		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//	}
//	
//	// 댓글 등록
//	@PostMapping("/{page}")
//	public ResponseEntity<SampleDTO> postSample(
//			@RequestBody SampleDTO dto,
//			@PathVariable(name="page") Integer page,
//			@RequestParam(name="perSheet") Integer perSheet){
//		
//		log.info("============ post sample ===============");
//		log.info(dto);
//		log.info("page : " + page);
//		log.info("perSheet : " + perSheet);
//		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
//	}
	
	// 댓글 조회
	// 받을 때 이런 애만 사용하겠다 = consumes
	// 이런 애만 반환 하겠다 = produces
	@GetMapping(value="/pages/{page}/{bno}", produces={ MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String, Object>> getRepliesPage(
				@PathVariable(name="page") Integer page,
				@PathVariable(name="bno") Integer bno
			){
		log.info("============ get RepliesPage ===============");
		log.info("PAGE : " + page);
		log.info("BNO : " + bno);
		Map<String, Object> resultMap = new HashMap<String, Object>();	

		PageDTO pageDTO = PageDTO.builder().page(page).perSheet(10).build();
		PageMaker pageMaker = new PageMaker(pageDTO, 45); 
		List<ReplyDTO> list = service.selectList(bno, pageDTO.getSkip());
		log.info("list : " + list);		
		log.info("============pageMaker============");	
		log.info(pageDTO);
		log.info("SKIP : " + pageDTO.getSkip());
		log.info(pageMaker);
		
		resultMap.put("list", list);
		resultMap.put("pageMaker", pageMaker);
		
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
}
