package com.winter.app.members;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.products.ProductVO;

@Mapper
public interface MemberDAO {
	
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	public int join(MemberVO memberVO) throws Exception;
	
	public int profileInsert(ProfileVO profileVO) throws Exception;
	
	public int addRole(Map<String, Object> map)throws Exception;

	public int cartAdd(Map<String, Object> map)throws Exception;
	
	public List<ProductVO> cartList(MemberVO memberVO) throws Exception;
}
