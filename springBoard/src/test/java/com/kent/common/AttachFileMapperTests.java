package com.kent.common;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kent.AbstractTests;
import com.kent.common.config.CommonConfig;
import com.kent.common.domain.AttachFile;
import com.kent.common.mapper.AttachFileMapper;

@ContextConfiguration(classes = {CommonConfig.class})
public class AttachFileMapperTests extends AbstractTests {
	
	@Autowired
	AttachFileMapper mapper;
	
	@Test
	public void testMapper() {
		show(mapper);
		
		AttachFile file = AttachFile.builder().uuid("ZZZZZZZZZZ").bno(1).fileName("ZZZ.jpg")
				.uploadPath("2021/03/19").build();
		
		show(file.getUuid());
		mapper.insert(file);
		show(file);
	}
	
	@Test
	public void testGetOneFile() {
		AttachFile file = mapper.getOneFile(1);
		show(file);
	}
	
}
