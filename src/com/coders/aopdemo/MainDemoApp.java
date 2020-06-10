package com.coders.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coders.aopdemo.dao.AccountDAO;
import com.coders.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

		//get the bean from the spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account theAccount =  new Account();
		
		// call the method on the bean
		theAccount.setName("Saygin");
		theAccount.setLevel("Platinum");
		theAccountDAO.addAccount(theAccount,true);
		theAccountDAO.addDoWork();
		
		theAccountDAO.setName("Rohit");
		theAccountDAO.setServiceCode("SerCode102");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		// call the method on the bean
		theMembershipDAO.addAccount();
		
		//close the context
		context.close();

	}

}
