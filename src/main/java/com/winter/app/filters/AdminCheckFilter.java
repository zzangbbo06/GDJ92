package com.winter.app.filters;

import java.io.IOException;

import com.winter.app.members.MemberVO;
import com.winter.app.members.RoleVO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		MemberVO memberVO = (MemberVO)req.getSession().getAttribute("member");
		// object가 반환되기때문에 형변환 필수
		boolean flag = false;
		
		for(RoleVO roleVO : memberVO.getRoleVOs()) {
			if(roleVO.getRoleName().equals("ROLE_ADMIN")) {
				flag = !flag;
				// true가 들어감
				break;
			}
	
		}
		if(flag) {
			
			// 관리자일경우 다음 단계 진행 시키면 된다 => chain.doFilter 이후로
			chain.doFilter(request, response);
		}else {
			req.setAttribute("msg", "권한이 없다잉~.~ 관리자로 승급해서 오소");
			req.setAttribute("url", "/");
			req.getRequestDispatcher("/WEB-INF/views/commons/result.jsp").forward(request, response);
			
		}
		
		
		
		
		
	}

}
