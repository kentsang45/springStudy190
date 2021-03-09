package org.kent.time.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j;

// 여기서 컨트롤러를 설정하지 말고
// 무조건 servletConfig에서만 설정해라.
// package 전체를 스캔하면 중복 스캔을 하는 경우가 있어서...
@Configuration
@MapperScan(basePackages = "org.kent.time.mapper")
@ComponentScan(basePackages = "org.kent.time.service")
@Log4j
public class TimeConfig {

	// TimeMapper를 스캔할 수 있어야한다.
	
}
