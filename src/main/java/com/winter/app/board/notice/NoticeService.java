package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardService;
import com.winter.app.board.BoardVO;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
//	private BoardDAO noticeDAO; -> 가능
	
	@Override
	public List<BoardVO> list() throws Exception {
		
		return noticeDAO.list();
	}
	
	public BoardVO detail(NoticeVO noticeVO) throws Exception{
		return noticeDAO.detail(noticeVO);
	}

}
