package com.winter.app.board;

public interface BoardDAO {
	
	
	// insert
	public int insert(BoardVO boardVO) throws Exception;
	public int update(BoardVO boardVO) throws Exception;
	public int delete(long boardNum) throws Exception;
	
}
