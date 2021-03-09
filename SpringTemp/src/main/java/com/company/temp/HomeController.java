package com.company.temp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.temp.user.service.ProductService;
import com.company.temp.user.service.ProductVO;

@Controller
public class HomeController {

	@Autowired
	ProductService service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// 등록 페이지
	@GetMapping("/insertProduct")
	public String insertProduct(ProductVO vo) {
		return "product/insertProduct";
	}

	// 등록 처리
	@PostMapping("/insertProduct")
	public String insertProductProc(ProductVO vo) {
		service.insertProduct(vo);
		return "redirect:/";
	}

	// 조회
	@GetMapping("/getSearchProduct")
	public String getSearchProduct(ProductVO vo, Model model) {
		model.addAttribute("list", service.getSearchProduct(vo));
		return "product/getSearchProduct";
	}

}
