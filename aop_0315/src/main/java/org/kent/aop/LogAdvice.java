package org.kent.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

// Spring에서 이 클래스를 관리해야한다.

@Aspect
@Component
@Log4j
public class LogAdvice {
	
	// 1. 해당 클래스에 모든 메서드에 걸어라.
//	@Before(value="execution(* org.kent.service.SampleService*.*(..))")
//	public void logBefore() {
//		log.info("========== BEFORE ==========");
//	}
	
	// 2. doA만 거는 방법
//	@Before(value="execution(* org.kent.service.SampleService*.doA(..))")
//	public void logBefore() {
//		log.info("========== BEFORE ==========");
//	}
	
	// 3. service 패키지의 모든 service 객체에... point cut 문법
//	@Before(value="execution(* org.kent.service.*Service*.*(..))")
//	public void logBefore() {
//		log.info("========== BEFORE ==========");
//	}
	
	// 4. 모든 도메인 서비스의 Service 객체
//	@Before(value="execution(* org.kent.**.service.*Service*.*(..))")
//	public void logBefore() {
//		log.info("========== BEFORE ==========");
//	}
//	@Before(value="execution(* org.kent.**.service.*Service*.*(..))")
//	public void logBefore() {
//		log.info("========== BEFORE ==========");
//	}
	
	// 5. 모든  Service 객체
//	@Before(value="execution(* org.kent..*.*Service*.*(..))")
//	public void logBefore() {
//		log.info("========== BEFORE ==========");
//	}
	
	@Before(value="execution(* org.kent..*.*Controller*.*(..))")
	public void logBeforeController(JoinPoint jp) {
		log.info("========== BEFORE ==========");
		
		// 그냥 JointPoint는 실행을 못 시킨다.
		String methodName =  jp.getSignature().getName(); // 메서드의 이름을 구하는 방법
		Object[] args = jp.getArgs();
		
		log.info("methodName  : " + methodName);
		log.info(Arrays.toString(args));
	}
	

	@Around(value="execution(* org.kent..*.*Service*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable{
		log.info("getTarget : " + pjp.getTarget());
		log.info("getThis : " + pjp.getThis());
		log.info("getSignature : " + pjp.getSignature());
		log.info("getArgs : " + pjp.getArgs());
		log.info("getKind : " + pjp.getKind());
		
		// 시간
		long start = System.currentTimeMillis();
		
		Object result = null;
		Object error = null;
		
		try {
			result = pjp.proceed();
		} catch(Throwable t) {
			t.printStackTrace();
			error = t;
		}
		
		long end = System.currentTimeMillis();
		
		log.info("=============== Time : "+(double)(end-start)+" ===============");
		log.info("=============== logTime end ===============");
		
		// 예외처리
		if(null != error) {
			throw (Throwable)error;
		}
		
		return result;
	}
	
	
}
