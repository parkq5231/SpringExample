package com.company.temp.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.temp.user.service.ProductService;
import com.company.temp.user.service.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper dao;

	// 등록
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
	}

	// 수정
	public void updateProduct(ProductVO vo) {
		dao.updateProduct(vo);
	}

	// 삭제
	public int deleteProduct(ProductVO vo) {
		return dao.deleteProduct(vo);
	}

	// 단건조회
	public ProductVO getProduct(ProductVO vo) {
		return dao.getProduct(vo);
	}

	// 전체조회
	public List<ProductVO> getSearchProduct(ProductVO vo) {
		return dao.getSearchProduct(vo);
	}
}
