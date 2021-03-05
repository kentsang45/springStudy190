package org.kent.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 이것이 설정 파일이다! 하고 선언하는 것.
@Configuration
@ComponentScan(basePackages = "org.kent.service")
public class RootConfig {
	
}
