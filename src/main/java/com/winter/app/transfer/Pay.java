package com.winter.app.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.winter.app.members.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
// 핵심 로직이 진행 될때 실행되어야 할 공통 로직
public class Pay {

	@Around("execution(* com.winter.app.transfer.Transfers.takeSubway(..))")	
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("탑승전 카드 체크");
		log.info("{}", joinPoint.getArgs());
		log.info("target {}", joinPoint.getTarget());
		log.info("kind : {}", joinPoint.getKind());
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("123");
		MemberVO [] members = new MemberVO[1];
		members[0]=memberVO;
		
		Object obj = joinPoint.proceed(members);
		// 무슨 타입으로 올지 모르기 때문에 Object로 받기
		log.info("return : {}", obj);
		System.out.println("하차시 카드 체크");
		return obj;
	}
}
