package edu.mum.cs.cs544.config;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingDeleteModelAspect {
	
	@After("execution(* edu.mum.cs.cs544.service.*.remove(..))")
	public void afterRemove(JoinPoint joinPoint){
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
		log.info(" System removed {}.{}, {} ", className, methodName, joinPoint.getArgs());
	}
	
	@AfterThrowing("execution(* edu.mum.cs.cs544.service.*.remove(..))")
	public void afterRemoveThrowExption(JoinPoint joinPoint){
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
		log.info(" [FAIL] System removed {}.{}, {} ", className, methodName, joinPoint.getArgs());
	}
}