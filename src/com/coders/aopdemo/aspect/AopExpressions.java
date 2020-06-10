package com.coders.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

	//Pointcut for getters
	@Pointcut("execution(* com.coders.aopdemo.dao.*.get*(..))")
	public void forGetters() {};

	//Pointcut for setters
	@Pointcut("execution(* com.coders.aopdemo.dao.*.set*(..))")
	public void forSetters() {};
	
	//Pointcut for dao package
	@Pointcut("execution(* com.coders.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	//Poincut for Dao Package Exclude Getters  And Setters
	@Pointcut("forDaoPackage() && !(forSetters()||forGetters())")
	public void forDaoPackageNoGettersAndSetters() {};	
	
}
