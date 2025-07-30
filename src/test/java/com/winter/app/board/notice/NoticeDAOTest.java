package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// springboot test 용도로만 쓸거에요
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void test() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardTitle("title3");
		noticeVO.setBoardContents("contents3");
		noticeVO.setBoardWriter("writer3");
		int result = noticeDAO.insert(noticeVO);
		
		// 단정문
		
		
//		NoticeVO noticeUpdateVO = new NoticeVO();
//		noticeUpdateVO.setBoardNum(6L);
//		noticeUpdateVO.setBoardTitle("title6");
//		noticeUpdateVO.setBoardContents("contents6");
//		noticeUpdateVO.setBoardWriter("writer6");
//		int result1 = noticeDAO.update(noticeUpdateVO);
		
//		NoticeVO noticeDeleteVO = new NoticeVO();
//		long boardNum = 3L;
//		int result2 = noticeDAO.delete(boardNum);
		
		assertEquals(1,result);
	}

}
