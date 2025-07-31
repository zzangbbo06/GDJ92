package com.winter.app.board.notice;

import com.winter.app.board.BoardVO;
import com.winter.app.home.HomeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public String noticeList(Model model) throws Exception {
		// spring을 jsp로 보내는 방법
		List<BoardVO> list = noticeService.list();
		
		model.addAttribute("list", list);
		return "notice/list";
	}
	
	@GetMapping("detail")
	public String detail(NoticeVO noticeVO, Model model) throws Exception{
		BoardVO detail = noticeService.detail(noticeVO);
		// BoardVO로 반환되기 때문에 NoticeVO로 받으면 형변환이 필요
		model.addAttribute("detail", detail);
		return "notice/detail";
	}
	
//	@GetMapping("add")
//	public void insert() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setBoardTitle("title");
//		noticeVO.setBoardContents("contents");
//		noticeVO.setBoardWriter("writer");
//		int result = noticeDAO.insert(noticeVO);
//	}
	
}
