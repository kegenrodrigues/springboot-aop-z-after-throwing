package com.coders.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coders.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

		//call the method findAccounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		//display accounts
		System.out.println("Printing list from mainapp: "+theAccounts);
		
		//close the context
		context.close();

	}

}
