package com.winter.app.board.notice;

import java.nio.channels.MulticastChannel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardFileVO;
import com.winter.app.board.BoardService;
import com.winter.app.board.BoardVO;
import com.winter.app.commons.FileManager;
import com.winter.app.commons.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
//	private BoardDAO noticeDAO; -> 가능
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${board.notice}")
	private String board;
	
	@Override
	public List<BoardVO> list(Pager pager) throws Exception {
		Long totalCount = noticeDAO.totalCount(pager);
		pager.makeNum(totalCount);
		return noticeDAO.list(pager);
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
	public int insert(BoardVO boardVO, MultipartFile [] attaches) throws Exception {
		int result = noticeDAO.insert(boardVO);
		// 자동증가된 boardNum을 사용
		if(attaches == null) {
			return result;
		}
		for(MultipartFile m: attaches) {
			
		
		if(m == null || m.isEmpty()) {
			continue;
		}
		//1. File을 HDD에 저장
		String fileName = fileManager.fileSave(upload+board, m);
		
		//2. 저장된 파일의 정보를 DB에 저장
		BoardFileVO vo = new BoardFileVO();
		vo.setOriName(m.getOriginalFilename());
		vo.setSaveName(fileName);
		vo.setBoardNum(boardVO.getBoardNum());
		result = noticeDAO.insertFile(vo);
		}
		return result;
		
	}
	
	@Override
	public int update(BoardVO boardVO, MultipartFile[] attaches) throws Exception {
		int result = noticeDAO.update(boardVO);
		if(attaches == null) {
			return result;
		}
		for(MultipartFile m: attaches) {
			
		
		if(m == null || m.isEmpty()) {
			continue;
		}
		//1. File을 HDD에 저장
		String fileName = fileManager.fileSave(upload+board, m);
		
		//2. 저장된 파일의 정보를 DB에 저장
		BoardFileVO vo = new BoardFileVO();
		vo.setOriName(m.getOriginalFilename());
		vo.setSaveName(fileName);
		vo.setBoardNum(boardVO.getBoardNum());
		result = noticeDAO.insertFile(vo);
		}
		return result;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		boardVO = noticeDAO.detail(boardVO);
		
		for(BoardFileVO vo : boardVO.getBoardFileVOs()) {
			fileManager.fileDelete(upload+board, vo.getSaveName());
		}
		
		int result = noticeDAO.fileDelete(boardVO);
		return noticeDAO.delete(boardVO);
	}

	@Override
	public int fileDelete(BoardFileVO boardFileVo) throws Exception {
		// 1. File 조회
		boardFileVo = noticeDAO.fileDetail(boardFileVo);
		// 2. File 삭제
		boolean result = fileManager.fileDelete(upload+board, boardFileVo.getSaveName());
		// 3. DB 삭제
		return noticeDAO.fileDeleteOne(boardFileVo);
	}


	
	
	

}