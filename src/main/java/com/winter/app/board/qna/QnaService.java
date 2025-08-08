package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardFileVO;
import com.winter.app.board.BoardService;
import com.winter.app.board.BoardVO;
import com.winter.app.commons.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardVO> list(Pager pager) throws Exception {
		Long totalCount = qnaDAO.totalCount(pager);
		pager.makeNum(totalCount);
		return qnaDAO.list(pager);
	}

	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		return qnaDAO.detail(boardVO);
	}

	public int reply(QnaVO qnaVO) throws Exception{
		QnaVO parent = (QnaVO)qnaDAO.detail(qnaVO);
		qnaVO.setBoardRef(parent.getBoardRef());
		qnaVO.setBoardStep(parent.getBoardStep()+1);
		qnaVO.setBoardDepth(parent.getBoardDepth()+1);
		
		int result = qnaDAO.replyUpdate(qnaVO);
		result = qnaDAO.insert(qnaVO);
		return result;
		
	}

	@Override
	public int insert(BoardVO boardVO, MultipartFile[] attaches) throws Exception {
		int result = qnaDAO.insert(boardVO);
		result = qnaDAO.refUpdate(boardVO);
		return result;
	}

	@Override
	public int update(BoardVO boardVO, MultipartFile[] attaches) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fileDelete(BoardFileVO boardFileVo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
