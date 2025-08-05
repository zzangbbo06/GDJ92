package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardService;
import com.winter.app.board.BoardVO;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardVO> list() throws Exception {
		return qnaDAO.list();
	}

	@Override
	public int insert(BoardVO boardVO) throws Exception {
		int result = qnaDAO.insert(boardVO);
		result = qnaDAO.refUpdate(boardVO);
		return result;
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
	public int delete(Long boardNum) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
