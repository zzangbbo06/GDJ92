package com.winter.app.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.products.ProductVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login() throws Exception{}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session) throws Exception{
		memberVO = memberService.login(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
		}
		
		
		return "redirect:/";
	}

	@GetMapping("join")
	public void join() throws Exception{}
	
	@PostMapping("join")
	public String join(MemberVO memberVO, MultipartFile profile) throws Exception{
		int result = memberService.join(memberVO, profile);
		
		return "redirect:/";
	}
	
	@GetMapping("detail")
	public void detail()throws Exception{}
	
	@PostMapping("detail")
	public String detail(MemberVO memberVO, HttpSession session, Model model) throws Exception{
		MemberVO detail = (MemberVO)session.getAttribute("member");
		// session에서 정보를 추출해서
		model.addAttribute("member", detail);
		//model로 정보를 내보내기
		return "member/detail";
		
	}
	@PostMapping("cartAdd")
	@ResponseBody
	public int cartAdd(Long productNum, HttpSession session)throws Exception{
		MemberVO memberVO =(MemberVO)session.getAttribute("member");
		Map<String, Object> map = new HashMap<>();
		map.put("username", memberVO.getUsername());
		map.put("productNum", productNum);
		
		return memberService.cartAdd(map);	
	}
	
	
	
	@GetMapping("cartList") 
    public String cartList(HttpSession session, Model model) throws Exception {
        MemberVO login = (MemberVO) session.getAttribute("member");
        if (login == null) {
        	return "redirect:/member/login";        	
        }

        // 장바구니 목록 (상품 정보 포함)
        List<ProductVO> items = memberService.cartList(login);
        model.addAttribute("cart", items);
        return "member/cartList"; 
    }
	
	@PostMapping("cartDelete")
	public String cartDelete(Long [] productNum, HttpSession session) throws Exception{		
		MemberVO login = (MemberVO)session.getAttribute("member");
		int cartDelete = memberService.cartDelete(productNum, login);
		return "redirect:./cartList";
	}
	
}
