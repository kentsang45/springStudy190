package org.vertigo.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "org.vertigo.board.mapper")
@ComponentScan(basePackages = "org.vertigo.board.service")
public class BoardConfig {

}
