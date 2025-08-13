package com.winter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ServletComponentScan
// 여기가 가장 먼저 실행되는데 servlet 관련된것은 여기다가 어노테이션을 해야 실행되어짐
public class Gdj92Application {

	public static void main(String[] args) {
		SpringApplication.run(Gdj92Application.class, args);
	}

}
