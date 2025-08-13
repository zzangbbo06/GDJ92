package com.winter.app.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.Filter;

@Configuration
// 설정용 파일이다
public class FilterConfig implements WebMvcConfigurer{
	
	@Bean
	FilterRegistrationBean<Filter> filterRegistrationBean() {
		// Filter를 등록하는 녀석이다 -> 이름만 봤을때는
		// Filter -> Filter를 상속받는 애
		FilterRegistrationBean<Filter> fr = new FilterRegistrationBean<>();
		
		fr.setFilter(new TestFilter());
		// 왜 new? 
		// 1. @component 사용 못해서 스프링이 안만들어주므로
		// 왜 어노테이션을 하지않았는가(왜 new로 했는가) -> component를 주게 되면 filter로 무조건 등록(먼저되어버림)되면서 사용되어짐
		
		fr.addUrlPatterns("/notice/*"); // 여기서 url 지정 가능
		fr.setOrder(2);
		// 숫자가 낮을수록 우선순위
		
		return fr;
	}
	
	
	@Bean
	FilterRegistrationBean<Filter> adminCheckFilter() {
		FilterRegistrationBean<Filter> fr = new FilterRegistrationBean<>();
		
		fr.setFilter(new AdminCheckFilter());
		fr.addUrlPatterns("/notice/add", "/notice/update", "/notice/update","/notice/delete");
		fr.setOrder(1);
		
		return fr;
	}
}
