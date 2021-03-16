package com.kent.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {
	
//	@Before(value="execution(* com.kent..*.*Controller*.*(..))")
//	public void logBeforeController(JoinPoint jp) {
//		log.info("====================== BEFORE CONTROLLER ==================");
//		
//		// 그냥 JointPoint는 실행을 못 시킨다.
//		String methodName =  jp.getSignature().getName(); // 메서드의 이름을 구하는 방법
//		Object[] args = jp.getArgs();
//		
//		log.info("methodName  : " + methodName);
//		log.info(Arrays.toString(args));
//	}
	
	
//	
//	@Around(value="execution(* com.kent..*.*Service*.*(..))")
//	public Object logTime(ProceedingJoinPoint pjp) {
//		log.info("=============== logTime start ===============");
//		
////		log.info("getTarget : " + pjp.getTarget());
////		log.info("getThis : " + pjp.getThis());
////		log.info("getSignature : " + pjp.getSignature());
////		log.info("getArgs : " + pjp.getArgs());
////		log.info("getKind : " + pjp.getKind());
//		
//		// 시간
//		long start = System.currentTimeMillis();
//		
//		Object result = null;
//		
//		try {
//			result = pjp.proceed();
//		} catch(Throwable e) {
//			e.printStackTrace();
//		}
//		
//
//		long end = System.currentTimeMillis();
//		
//		log.info("=============== Time : "+(double)(end-start)+" ===============");
//		log.info("=============== logTime end ===============");
//		
//		return result;
//	}
}
