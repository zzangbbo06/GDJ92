package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.winter.app.board.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
// springboot test 용도로만 쓸거에요
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void detailTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardNum(1L);
		BoardVO boardVO = noticeDAO.detail(noticeVO);
//		모든 noticeVO는 boardVO 가 아니기때문
		log.info("result : {}" , boardVO);
		assertNotNull(boardVO);
	}
	//@Test
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
		
//		assertEquals(1,result);
	}

}
