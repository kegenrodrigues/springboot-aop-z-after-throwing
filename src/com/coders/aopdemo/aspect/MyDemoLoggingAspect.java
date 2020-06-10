package com.coders.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.coders.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@AfterThrowing(pointcut = "execution(* com.coders.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theException")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("afterThrowingExceptionAdvice was called after this method threw an exception: "+method);
		System.out.println("The exception is :"+theException);
	}
	
	
	@AfterReturning(pointcut = "execution(* com.coders.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("afterReturningAdvice was called after this method finished: "+method);
		System.out.println("The list is as follows: "+result);
		
		
		convertToUpperCase(result);
	
	}
	
	private void convertToUpperCase(List<Account> result) {
		
		if(result != null) {
			for(Account tempAccount : result) {
				tempAccount.setName(tempAccount.getName().toUpperCase());
			}
		}
		
	}

	@Before("com.coders.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
	public void runBeforeAddAccount(JoinPoint theJointPoint) {
		
		System.out.println("Buddy we are in the logging Aspect. runBeforeAddAccount");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();
		System.out.println("Method: "+methodSig);
		
		//display the method arguments
		Object[] args = theJointPoint.getArgs();
		
		for (Object tempArg:args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				Account theAccount = (Account)tempArg;
				System.out.println("Name: "+theAccount.getName());
				System.out.println("Level: "+theAccount.getLevel());
			}
			
		}
		
	}
		
}
