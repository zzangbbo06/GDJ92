package com.winter.app.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.board.BoardVO;
import com.winter.app.board.notice.NoticeDAO;
import com.winter.app.members.MemberVO;
import com.winter.app.members.RoleVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateWriterCheckInterceptor implements HandlerInterceptor{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		
		if(request.getMethod().toUpperCase().equals("POST")) {
			return;
		}
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		BoardVO boardVO = (BoardVO)modelAndView.getModel().get("vo");
		
		if(!memberVO.getUsername().equals(boardVO.getBoardWriter())) {
			modelAndView.setViewName("commons/result");
			modelAndView.addObject("msg", "작성자만 가능");
			modelAndView.addObject("url", "./list");
		}
				
	}
}
