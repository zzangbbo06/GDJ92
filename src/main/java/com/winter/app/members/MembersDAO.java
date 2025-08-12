package com.winter.app.members;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MembersDAO {
	public int join(MembersVO membersVo) throws Exception;
	public int profileInsert(ProfileVO profileVo) throws Exception;
}
