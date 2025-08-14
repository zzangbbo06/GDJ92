package com.winter.app.configs;


import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig implements WebMvcConfigurer{

	@Bean
	 LocaleResolver localeResolver() {
		//1.session
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
		
		//2.Cookie
		CookieLocaleResolver resolver2 = new CookieLocaleResolver("lang");
		/* resolver2.setDefaultLocale(Locale.KOREAN); */
		
		return resolver2;
		
	}
		
		//Message Interceptor
		
		LocaleChangeInterceptor changeInterceptor() {
			LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
			//url?lang=ko
			changeInterceptor.setParamName("lang");
		
			return changeInterceptor;
	}
		
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(this.changeInterceptor())
					.addPathPatterns("/**");
		}
}
