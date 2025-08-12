package com.winter.app.transfers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.winter.app.board.notice.NoticeDAO;
import com.winter.app.board.notice.NoticeVO;

@Transactional
@SpringBootTest
public class NoticeDAOTest {

	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	@Rollback(false)
	void insertTest() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardTitle("titleDelete");
		noticeVO.setBoardContents("contents");
		noticeVO.setBoardWriter("writer");
		int result = noticeDAO.insert(noticeVO);
		
		
		assertEquals(1, result);
	}
}
