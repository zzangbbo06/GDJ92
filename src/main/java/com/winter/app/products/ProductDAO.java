package com.winter.app.products;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
// 객체 만들어서 사용할 거다 얘가 mapper다
public interface ProductDAO {
 
	public List<ProductVO> list() throws Exception;
	public ProductVO detail(ProductVO productVO) throws Exception;
	public int add(ProductVO productVO) throws Exception;
	public int update(ProductVO productVO) throws Exception;
	public int delete(ProductVO productVO) throws Exception;
}
