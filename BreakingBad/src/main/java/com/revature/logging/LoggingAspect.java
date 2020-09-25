package com.revature.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.controllers.*)")
	public void logControllerMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	
	@AfterReturning(pointcut="execution(* login(..))", returning="returnedObject")
	public void logLogin(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@AfterReturning(pointcut="execution(* newUser(..))", returning="returnedObject")
	public void logNewUser(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@AfterReturning(pointcut="execution(* findQuote(..))", returning="returnedObject")
	public void logFindQuote(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@AfterReturning(pointcut="execution(* newQuote(..))", returning="returnedObject")
	public void logNewQuote(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	
	
}
