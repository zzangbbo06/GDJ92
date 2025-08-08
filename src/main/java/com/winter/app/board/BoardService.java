package com.winter.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.winter.app.commons.Pager;

public interface BoardService {

	// list
	public List<BoardVO> list(Pager pager) throws Exception;
	
	/* public int add(BoardVO boardVO) throws Exception; */
	//insert
	public int insert(BoardVO boardVO, MultipartFile[] attaches) throws Exception;
	//detail
	public BoardVO detail(BoardVO boardVO) throws Exception;
	//update
	public int update(BoardVO boardVO, MultipartFile[] attaches) throws Exception;
	//delete
	public int delete(BoardVO boardVO) throws Exception;
	//fileDelete
	public int fileDelete(BoardFileVO boardFileVo) throws Exception;
}
