package com.winter.app.board;

import java.util.List;

import com.winter.app.board.notice.NoticeVO;

public interface BoardDAO {
	
	// detail
	public BoardVO detail(BoardVO boardVO) throws Exception;
	
	// insert
	public int insert(BoardVO boardVO) throws Exception;
	public int update(BoardVO boardVO) throws Exception;
	public int delete(long boardNum) throws Exception;
	public List<BoardVO> list() throws Exception;
	
}
