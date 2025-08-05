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
	
	public BoardVO detail(BoardVO noticeVO) throws Exception{
		return noticeDAO.detail(noticeVO);
	}

	/*
	 * @Override public int add(BoardVO boardVO) throws Exception {
	 * 
	 * return noticeDAO.add(boardVO); }
	 */

	@Override
	public int insert(BoardVO boardVO) throws Exception {
		return noticeDAO.insert(boardVO);
	}
	

	@Override
	public int delete(Long boardNum) throws Exception {
		return noticeDAO.delete(boardNum);
	}

	@Override
	public int update(BoardVO boardVO) throws Exception {
		return noticeDAO.update(boardVO);
	}

	
	
	

}