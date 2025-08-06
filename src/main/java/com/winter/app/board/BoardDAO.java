package com.winter.app.board;

import java.util.List;

import com.winter.app.commons.Pager;



public interface BoardDAO {
	
	// detail
	public BoardVO detail(BoardVO boardVO) throws Exception;
	
	// insert
	public int insert(BoardVO boardVO) throws Exception;
	public int insertFile(BoardFileVO boardFileVo) throws Exception;
	public int update(BoardVO boardVO) throws Exception;
	public int delete(Long boardNum) throws Exception;
	public List<BoardVO> list(Pager pager) throws Exception;
	
	public Long totalCount() throws Exception;
	
	
}
