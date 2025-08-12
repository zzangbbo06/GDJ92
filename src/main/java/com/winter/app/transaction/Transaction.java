package com.winter.app.transaction;

import org.springframework.stereotype.Component;

@Component
public class Transaction {

	public void t() {
		System.out.println("session을 false");
		
		System.out.println("commit");
	}
	
	public void t2() {
		System.out.println("session을 success");
		
		System.out.println("commit");
	}
}
