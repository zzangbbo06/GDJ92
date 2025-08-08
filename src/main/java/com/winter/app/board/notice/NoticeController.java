package com.winter.app.board.notice;

import com.winter.app.board.BoardFileVO;
import com.winter.app.board.BoardVO;
import com.winter.app.commons.Pager;


import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/notice/*")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@Value("${board.notice}")
	// properties 안에 있는 값을 java로 가져와서 사용
	private String name;
	
	@ModelAttribute("board")
	// 모든 메소드가 실행될때 한번씩 같이 실행 
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("list")
	public String noticeList(Pager pager,Model model) throws Exception {
		
		// spring을 jsp로 보내는 방법
		List<BoardVO> list = noticeService.list(pager);
		
		model.addAttribute("pager",pager);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("detail")
	public String detail(NoticeVO noticeVO, Model model) throws Exception{
		BoardVO detail = noticeService.detail(noticeVO);
		// BoardVO로 반환되기 때문에 NoticeVO로 받으면 형변환이 필요
		model.addAttribute("detail", detail);
		return "board/detail";
	}
	@GetMapping("add")
	public String add() throws Exception{
		return "board/add";
	}
	
	/*
	 * @PostMapping("add") public String detail(String boardTitle, String
	 * boardContents, String boardWriter) throws Exception{ NoticeVO noticeVO = new
	 * NoticeVO(); noticeVO.setBoardTitle(boardTitle);
	 * noticeVO.setBoardContents(boardTitle); noticeVO.setBoardWriter(boardWriter);
	 * int add = noticeService.add(noticeVO); return "redirect:./list"; }
	 */
	
	@PostMapping("add")
	public String add(NoticeVO noticeVO, MultipartFile[] attaches) throws Exception{
		
		int result = noticeService.insert(noticeVO, attaches);
		return "redirect:./list";
	}
	
//	@GetMapping("update")
//	public String update() throws Exception{
//		
//		return "notice/update";
//	}
	
	@GetMapping("update")
	public String update(BoardVO noticeVO, Model model) throws Exception{
		BoardVO boardVO = noticeService.detail(noticeVO);
		model.addAttribute("vo", boardVO);
		return "board/add";
	}
	@PostMapping("update")
	public String update(NoticeVO noticeVO, Model model, MultipartFile[] attaches) throws Exception{
		int result = noticeService.update(noticeVO, attaches); //insert(noticeVO);
		
		String msg ="수정 실패";
		
		if(result>0) {
			msg="수정 성공";
		}
		
		String url="./detail?boardNum="+noticeVO.getBoardNum();
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "commons/result"; 
		
		//"redirect:./detail?boardNum="+noticeVO.getBoardNum();
	}
	
	@PostMapping("delete")
	public String delete(BoardVO boardVO, Model model) throws Exception {
		int result = noticeService.delete(boardVO);
		String msg = "삭제 실패";
		
		if(result != 0) {
			System.out.println("notice/delete: 성공");
			msg = "삭제 성공";
		} else {
			System.out.println("notice/delete: 실패");
		}
		
		String url = "./list";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	// 응답을 바로 요청시 정한 dataType의 형식으로 내보냄
	public int fileDelete(BoardFileVO boardFileVO, MultipartFile[] attaches,Model model) throws Exception{
		int result = noticeService.fileDelete(boardFileVO); 
		
		return result;
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