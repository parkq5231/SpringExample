package com.company.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.temp.common.BankAPI;

@Controller
public class BankController {
	String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMTExNjc5Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjIzMzA2NTcxLCJqdGkiOiJhNGZlNmVhNC02ZTIxLTQyOGMtYmE4OC0xMmJmOGVkNzhlMjUifQ.2XEjjmT1-5IFIXn_vC-yAnJ72LB2JyXkAffwefgtg4k";
	@Autowired
	BankAPI bankAPI;

	// 실명확인
	@RequestMapping("/getRealName")
	public List<String> getRealName(HttpSession session, Model model) throws Exception {
		List<String> list = new ArrayList<String>();
		String user_num = "1100770536";
		Map<String, Object> map = bankAPI.getRealName(org_access_token);
		System.out.println("map값 확인용" + map);
		List<String> result = (List<String>) map.get("account_holder_name");
		System.out.println("값: " + result);
		for (String name : result) {
			list.add(name);
		}
		return list;
	}

}
