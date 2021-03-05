package org.gyus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args)throws Exception {
		
		ApplicationContext ctx = null;
		
		ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		System.out.println(ctx);
		
		 Object obj = ctx.getBean("a1");
		 
		 System.out.println(obj); //bean 안에 잘 들어갔는지 확인차 한번 출력해본다.
		
		 
	}
}
