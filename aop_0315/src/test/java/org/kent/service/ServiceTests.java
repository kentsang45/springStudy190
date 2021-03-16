package org.kent.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ServiceTests {

	@Autowired
	SampleService service;
	
	@Test
	public void show() {
		// 결과로 com.sum.proxy.$Proxy23
		// $는 익명 클래스로 만들어졌을 떄 붙는다.
		// 즉 실제 클래스가 아닌 Proxy...로 감싸진 것
		// 얘가 동작하면서 aop가 결합된 상태... 따라서 log가 찍힌다.
		log.info(service.getClass().getName());
		
		log.info(service.doA());
		log.info(service.doB());
		log.info(service.doC());
	}
	
	@Test
	public void testTX() {
		// 결과로 com.sum.proxy.$Proxy23
		// $는 익명 클래스로 만들어졌을 떄 붙는다.
		// 즉 실제 클래스가 아닌 Proxy...로 감싸진 것
		// 얘가 동작하면서 aop가 결합된 상태... 따라서 log가 찍힌다.
		log.info(service.testTX());
	}
	
	@Test
	public void testLastIndex() {
		// 결과로 com.sum.proxy.$Proxy23
		// $는 익명 클래스로 만들어졌을 떄 붙는다.
		// 즉 실제 클래스가 아닌 Proxy...로 감싸진 것
		// 얘가 동작하면서 aop가 결합된 상태... 따라서 log가 찍힌다.
		service.insertBoardTest();
		
	}
}
