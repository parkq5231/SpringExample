package com.company.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.temp.common.BankAPI;

@Controller
public class BankController {
	String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMTExNjc5Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjIzMzA2NTcxLCJqdGkiOiJhNGZlNmVhNC02ZTIxLTQyOGMtYmE4OC0xMmJmOGVkNzhlMjUifQ.2XEjjmT1-5IFIXn_vC-yAnJ72LB2JyXkAffwefgtg4k";
	@Autowired
	BankAPI bankAPI;

	// 실명확인
	@RequestMapping("/getRealName")
	@ResponseBody
	public String getRealName(HttpSession session, Model model, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		List<String> list = new ArrayList<String>();

		String result = bankAPI.getRealName(org_access_token);
		// (List<String>) map.get("account_holder_name");
		System.out.println("값: " + result);
		return result;
	}
}
