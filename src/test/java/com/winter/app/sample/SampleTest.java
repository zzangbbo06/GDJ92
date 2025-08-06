package com.winter.app.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleTest {
	
	@Test
	void test() {
		// 1 => 1
		// 2 => 2
		// 4 => 10
		// 5 => 11
		// 6 => 12
		// 7 => 13
		// 8 => 20
		// 9 => 21
		
		int n = 5;
		int result = n/4*10 + n%4;
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		// 편의점
		int price = 34500;
		int money = 50000;
		int change = money - price;
		
		
		int man = change / 10000;
		int chon = (change % 10000) / 1000;
		System.out.println("만원 " + man + "장" ) ;
		System.out.println("천원 " + chon + "장" ) ;
	}
}

