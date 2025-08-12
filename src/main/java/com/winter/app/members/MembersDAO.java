package com.winter.app.members;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MembersDAO {
	public int join(MembersVO membersVo) throws Exception;
	public int profileInsert(ProfileVO profileVo) throws Exception;
	public int addRole(Map<String, Object> map)throws Exception;
}
