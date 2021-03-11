package com.kent.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.kent.board.service")
@MapperScan(basePackages = "com.kent.board.mapper")
public class BoardConfig {
	
}
