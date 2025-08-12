package com.winter.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.winter.app.commons.FileManager;
import com.winter.app.transaction.Transaction;

@Service
public class MemberService {

	@Autowired
	private MembersDAO membersDAO;
//	private BoardDAO noticeDAO; -> 가능
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${board.member}")
	private String board;
	
	@Autowired
	private Transaction transaction;
	
	public int join(MembersVO membersVO, MultipartFile profile) throws Exception{
		
		int result = membersDAO.join(membersVO);
		
		ProfileVO profileVO = new ProfileVO();
		profileVO.setUsername(membersVO.getUsername());
		profileVO.setSaveName("default.jpg");
		profileVO.setOriName("default.jpg");
		if(profile != null && !profile.isEmpty()) {
			String saveName = fileManager.fileSave(upload + board, profile);
			profileVO.setSaveName(fileManager.fileSave(upload+board, profile));
			profileVO.setOriName(profile.getOriginalFilename());
			
			if(profile != null) {
				throw new Exception();
			}
		}
		
		result = membersDAO.profileInsert(profileVO);
		
		
		return result;
		
	}
}
