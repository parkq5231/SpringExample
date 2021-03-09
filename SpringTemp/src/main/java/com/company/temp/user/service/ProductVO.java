package com.company.temp.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProductVO {
	private Integer product_id;
	private String product_name;
	private Integer product_price;
	private String product_info;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date product_date;
	private String company;
	private String manager_id;
}
