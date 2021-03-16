package org.kent.controller;

import org.kent.domain.SampleDTO;
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

import lombok.extern.log4j.Log4j;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/samples")
@Log4j
public class SampleController {

	@PutMapping("/{sno}")
	public ResponseEntity<SampleDTO> modifySample(@RequestBody SampleDTO dto){
		log.info("============ modify sample ===============");
		log.info("DTO : " + dto);
		
		
		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{sno}")
	public ResponseEntity<Boolean> deleteSample(@PathVariable(name="sno") Integer sno ){
		log.info("============ delete sample ===============");
		log.info("SNO : " + sno);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@PostMapping("/{page}")
	public ResponseEntity<SampleDTO> postSample(
			@RequestBody SampleDTO dto,
			@PathVariable(name="page") Integer page,
			@RequestParam(name="perSheet") Integer perSheet){
		
		log.info("============ post sample ===============");
		log.info(dto);
		log.info("page : " + page);
		log.info("perSheet : " + perSheet);
		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
	}
	
	
	// 받을 때 이런 애만 사용하겠다 = consumes
	// 이런 애만 반환 하겠다 = produces
	@GetMapping(value="/get", produces={ MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SampleDTO> getSample(){
		log.info("============ get sample ===============");
		return new ResponseEntity<SampleDTO>(new SampleDTO(11, "샘플", "샘플"), HttpStatus.OK);
	}
	
}
