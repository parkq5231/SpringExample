package com.company.temp.user.service;

import java.util.List;

public interface ProductService {
	// 등록
	public void insertProduct(ProductVO vo);

	// 단건조회
	public ProductVO getProduct(ProductVO vo);

	// 전체조회
	public List<ProductVO> getSearchProduct(ProductVO vo);
}
