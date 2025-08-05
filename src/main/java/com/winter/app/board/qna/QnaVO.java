package com.winter.app.board.qna;

import com.winter.app.board.BoardVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class QnaVO extends BoardVO{
	
	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;	
	
	//setter
	//public void set변수명(매개변수){}
	public Long getBoardRef() {
		if(this.boardRef == null) {
			this.boardRef = 0L;
		}
		return this.boardRef;
	}
	public Long getBoardStep() {
		if(this.boardStep == null) {
			this.boardStep = 0L;
		}
		return this.boardStep;
	}
	public Long getBoardDepth() {
		if(this.boardDepth == null) {
			this.boardDepth = 0L;
		}
		return this.boardDepth;
	}
}
