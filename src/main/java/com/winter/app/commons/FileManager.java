package com.winter.app.commons;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	public boolean fileDelete(String dir, String fileName) throws Exception{
		File file = new File(dir,fileName);
		return file.delete();
	}
	
	
	public String fileSave(String dir, MultipartFile attaches) throws Exception{
		//1.디렉토리 생성
		File file = new File(dir);
		if(!file.exists()) {
			file.mkdirs();
//			mkdirs 중간폴더가 없으면 거기까지 만들어줘라
		}
		
		//2. 저장할 파일명을 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+attaches.getOriginalFilename();
		
		// 3. HDD에 저장
		file = new File(file, fileName);
		// 어느 디렉토리에 어떤 이름으로
		
		//a. Multipartfile transferTo 메서드 사용
//		attaches.transferTo(file);
		// b. FileCopyUtils의 copy 메서드 사용
		FileCopyUtils.copy(attaches.getBytes(), file);
//		여기까지 하면 파일 저장이 된것
		return fileName;
	}
}
