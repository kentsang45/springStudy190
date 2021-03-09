package org.kent.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j;

@Configuration
@MapperScan(basePackages = "org.kent.board.mapper")
@ComponentScan(basePackages = "org.kent.board.service")
@Log4j
public class BoardConfig {
	
}
