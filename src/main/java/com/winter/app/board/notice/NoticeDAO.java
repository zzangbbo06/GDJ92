package com.winter.app.board.notice;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.board.BoardDAO;

@Mapper
// 메소드, 객체 전부 알아서 생성 오버라이드도 알아서 해줌
public interface NoticeDAO extends BoardDAO{
	
}
