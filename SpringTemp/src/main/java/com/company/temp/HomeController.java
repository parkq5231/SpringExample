package com.company.temp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.temp.common.MovieAPI;
import com.company.temp.user.service.ProductService;
import com.company.temp.user.service.ProductVO;
import com.company.temp.user.service.SaleService;
import com.company.temp.user.service.SaleVO;

@Controller
public class HomeController {

	@Autowired
	ProductService service;
	
	@Autowired
	SaleService saleservice;

	@Autowired
	MovieAPI movieAPI;

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

	// 상품번호에 해당하는상품정보 조회
	@RequestMapping("/getProduct")
	@ResponseBody // json으로 넘겨줌
	public ProductVO getProduct(ProductVO vo) {
		vo = service.getProduct(vo);
		return vo;
	}

	// 구매정보 sale 테이블에 등록
	@PostMapping("/insertSale")
	@ResponseBody
	public Map insertSale(SaleVO vo) {
		boolean bool = saleservice.insertSale(vo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", bool);
		return map;
	}

	// 영화정보조회
	@RequestMapping("/moviedirectors")
	@ResponseBody // 넘겨줄때 자동으로 json형태로 넘겨줌
	public List<String> moviedirectors() {
		List<String> list = new ArrayList<String>();
		// 가져온 값 map에 담기
		Map map = movieAPI.moviedirectors();
		//
		Map movieInfoResult = (Map) map.get("movieInfoResult");
		//
		Map movieInfo = (Map) movieInfoResult.get("movieInfo");
		// List의 Map타입으로 담음
		List<Map> directors = (List<Map>) movieInfo.get("directors");
		// Loop
		for (Map director : directors) {
			list.add((String) director.get("peopleNm"));
		}

		return list;
	}
	
}
