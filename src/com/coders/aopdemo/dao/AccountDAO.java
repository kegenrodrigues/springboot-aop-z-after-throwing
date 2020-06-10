package com.coders.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coders.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public String getName() {
		System.out.println(getClass()+" in getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass()+" in setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass()+" in getServiceCode()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" in setServiceCode()");
		this.serviceCode = serviceCode;
	}


	public void addAccount(Account account,boolean b) {
		
		System.out.println(getClass()+" :Doing my db work of adding account");
	}
	
	
	public void addDoWork() {
		
		System.out.println(getClass()+" :Doing work");
	}
	
	
	public List<Account> findAccounts(boolean tripwire){
		
		if(tripwire) {
			throw new RuntimeException("Exception is thrown from findAccounts()");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("Valentina","Platinum");
		Account temp2 = new Account("Jack","Silver");
		Account temp3 = new Account("Juliet","Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		System.out.println("Just gonna finish executing findAccounts");
		return myAccounts;
	}
	
}













