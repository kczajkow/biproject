package com.czajkowski.operation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.czajkowski.operation..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("******LoggingAspect: " + joinPoint.getSignature().toLongString() + " is running!");
	}
	
	@Before("execution(* org.springframework.orm.hibernate3.HibernateTransactionManager..*(..))")
	public void logBeforeT(JoinPoint joinPoint) {
		System.out.println("!!!!!!TRANSACTION: " + joinPoint.getSignature().toShortString() + " is running!");
	}
	
	
}
