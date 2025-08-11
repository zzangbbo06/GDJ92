package com.winter.app.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardVO;
import com.winter.app.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@Value("${board.qna}")
	private String name;
	
	@ModelAttribute("board")
	// 모든 메소드가 실행될때 한번씩 같이 실행 
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception{
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", qnaService.list(pager));
		
		return "board/list";
	}
	@GetMapping("detail")
	public String detail(QnaVO qnaVO, Model model) throws Exception{
		BoardVO detail = qnaService.detail(qnaVO);
		model.addAttribute("detail", detail);
		
		return "board/detail";
	}
	@GetMapping("reply")
	public String reply(QnaVO qnaVO, Model model) throws Exception{
		model.addAttribute("vo", qnaVO);
		return "board/add";
		
	}
	@PostMapping("reply")
	public String reply2(QnaVO qnaVO, Model model) throws Exception{
		int result = qnaService.reply(qnaVO);
		return "redirect:./list";
	}
	// qna/add
	@GetMapping("add")
	
	public String insert(QnaVO qnaVO) throws Exception{
		return "board/add";
		// jsp 주소
	}
	@PostMapping("add")
	public String insert(QnaVO qnaVO, MultipartFile[] attaches) throws Exception {
		log.info("{}", attaches);
		int result = qnaService.insert(qnaVO, attaches);
		return "redirect:/qna/list";
	}
	@GetMapping("update")
	public String update(QnaVO qnaVO) throws Exception{
		return "board/update";
	}
}
