//package org.kent.main;
//
//import org.kent.config.RootConfig;
//import org.kent.service.Chef;
//import org.kent.service.MenuService;
//import org.kent.service.Restaurant;
//import org.kent.ui.MenuUI;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class Main {
//	
//	// bad code : throws Exception
//	public static void main(String[] args) throws Exception {
//		// ApplicationContext 를 로딩하는 방법...
//		// web은 바로 들어갈 수 있다.
//		ApplicationContext ctx = null;
//		//ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
//		
//		ctx = new AnnotationConfigApplicationContext(RootConfig.class);
//		
//		// System.out.println(ctx);
//		
//		// MenuService service = (MenuService)ctx.getBean("m1");
//		
//		// root-context에 등록한 bean을 가져온다.
//		// getBean함수는 Object를 반환...
//		// 그리고 기본적으로 Singleton으로 등록된다.
//		// Object obj = ctx.getBean("m1");
//		// System.out.println(obj);
//		
//		// MenuUI ui = (MenuUI)ctx.getBean("mui");
//		
//		// System.out.println(ui);
//		
//		Chef chef = ctx.getBean(Chef.class);
//		
//		
//		System.out.println(Chef.class);
//		
//		Restaurant res = ctx.getBean(Restaurant.class);
//		
//		System.out.println(res);     
//		
//		
//		
//		System.out.println(add(100, 200));
//		
//		// 생성자 함수를 호출 하면 객체를 반환한다.
//		Restaurant rest = new Restaurant();
//	
//		int total = add(100, 200);
//	}
//	
//	private static int add(int a, int b) {
//		int c = a + b;
//		int d = 100;
//		// System.out.println(ctx);
//		return c;
//	}
//	
//}
