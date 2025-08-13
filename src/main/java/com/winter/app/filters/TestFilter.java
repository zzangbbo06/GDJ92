package com.winter.app.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



//@WebFilter(urlPatterns = {"/notice/*", "/qna/*"})
// urlPatterns -> string 배열
//@Component
// 객체 만드는 어노테이션
//@Order(1)
public class TestFilter implements Filter {
       
   
    public TestFilter() {
    	// 메소드...? 특수한 메소드 객체를 만들때 ...? 생성자랑은 다른건가..
        super();
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청이 들어오면 doFilter가 가장 먼저 실행 
		System.out.println("Test Filter In");
		chain.doFilter(request, response);
		//나갈때
		System.out.println("Test Filter Out");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
