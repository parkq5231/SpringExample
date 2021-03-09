package com.company.temp.user.service.impl;

import java.util.List;

import com.company.temp.user.service.ProductVO;

public interface ProductMapper {
	// 등록
	public void insertProduct(ProductVO vo);

	// 수정
	public void updateProduct(ProductVO vo);

	// 삭제
	public int deleteProduct(ProductVO vo);

	// 단건조회
	public ProductVO getProduct(ProductVO vo);

	// 전체조회
	public List<ProductVO> getSearchProduct(ProductVO vo);
}
