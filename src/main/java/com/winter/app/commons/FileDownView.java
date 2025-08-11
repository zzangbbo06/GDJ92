package com.winter.app.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.winter.app.board.BoardFileVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class FileDownView extends AbstractView{
	
	@Value("${app.upload}")
	private String path;
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		log.info("===========custom view==============");
		log.info("============{}===========", model);
		
		BoardFileVO boardFileVO = (BoardFileVO)model.get("vo");
		//object 형식으로 날아오기때문에 형변환 필요
		
		String filePath = path+model.get("board").toString();
		
		File file = new File(filePath, boardFileVO.getSaveName());
		
		// 총 파일의 크기
		response.setContentLengthLong(file.length());
		// file.length가 long이기때문에 바로 LengthLong으로
		
		// 파일 다운시 파일의 이름을 인코딩
		String fileName = URLEncoder.encode(boardFileVO.getOriName(), "UTF-8");
		
		// header 설정
		//응답이기때문에 response
		response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
		// 다운로드할때 쓰는 이름이 이거다 fileName
		response.setHeader("Content-Transfer-Encoding","binary");
		//binary 0과1로 가는 파일이다
		
		// File을 읽어서
		FileInputStream fis = new FileInputStream(file);
		
		//Client로 연결
		// 읽어서 내보내는거 연결
		OutputStream os = response.getOutputStream();
		
		// 전송
		FileCopyUtils.copy(fis, os);
		
		// 자원 해제
		// 연결된 순서에 역순
		os.close();
		fis.close();
		
		
		
		
		
	}
}
