package org.kent.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

// == RootConfig

@Configuration 
@Log4j
public class CommonConfig {
	
	@Bean
	public String test() {
		log.info("CommonConfig started......................");
		return "Common Config Test";
	}
	
	// DataSource 빈 설정
	@Bean
	public DataSource dataSource() {
		// HikariConfig 생성 및 설정
		HikariConfig hc = new HikariConfig();
		hc.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hc.setJdbcUrl("jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC");
		hc.setUsername("vertigo");
		hc.setPassword("vertigo");
		
		// hikari DataSource를 만들자
		HikariDataSource hds = new HikariDataSource(hc);
		return hds;
	}
	
	// SessionFactory 빈 설정
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		
		// DataSoource를 생성하는 함수를 호출해야한다!
		ssf.setDataSource(dataSource());
		
		// mybatis config 파일 경로를 여기 넣으면 된다. 
		// ssf.setConfiguration(null);
		
		return ssf.getObject();
	}
	
	
	
	
}
