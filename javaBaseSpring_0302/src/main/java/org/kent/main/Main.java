package org.kent.main;

import org.kent.config.RootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx =
			new AnnotationConfigApplicationContext(RootConfig.class);
		
		System.out.println(ctx);
		
		
	}
	
}
