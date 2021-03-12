package com.company.temp.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.temp.user.service.SaleService;
import com.company.temp.user.service.SaleVO;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	SaleMapper dao;

	public boolean insertSale(SaleVO vo) {
		return dao.insertSale(vo);
	}
}
