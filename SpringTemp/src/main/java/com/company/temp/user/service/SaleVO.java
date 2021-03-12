package com.company.temp.user.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SaleVO {
	private Integer sale_seq;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sale_date;
	private Integer product_id;
	private Integer sale_qty;
	private Integer sale_price;
	private String member_id;

}
