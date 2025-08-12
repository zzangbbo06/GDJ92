package com.winter.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String login() throws Exception{
		return "members/login";
	}
	
	
	
	@GetMapping("join")
	public String join() throws Exception{
		return "members/join";
	}
	
	@PostMapping("join")
	public String memberJoin(MembersVO member,
	                         String passwordConfirm,
	                         MultipartFile profile) throws Exception {
	    if (member.getPassword() == null || member.getPassword().isBlank()) {
	        return "redirect:/member/join";
	    }
	    if (!member.getPassword().equals(passwordConfirm)) {
	        return "redirect:/member/join";
	    }
	    if (member.getUsername() == null || member.getUsername().isBlank()) {
	        return "redirect:/member/join";
	    }
	    memberService.join(member, profile);
	    return "redirect:/member/login";
	}
}
