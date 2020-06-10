package com.coders.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coders.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

		//call the method findAccounts
		
		List<Account> theAccounts = null;
		
		
		try {
			boolean tripwire = true;
			theAccounts = theAccountDAO.findAccounts(tripwire);
		
		}catch(Exception exc) {
		
			System.out.println("Exception caught in main method: "+exc);
		
		}
		//display accounts
		System.out.println("Printing list from mainapp: "+theAccounts);
		
		//close the context
		context.close();

	}

}
