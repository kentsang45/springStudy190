package org.kent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@ToString
@RequiredArgsConstructor
public class Restaurant {
	
	// 스프링 자동 주입
	@Autowired
	private final Chef chef;
	
	// 생성자 주입

}
