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
	String access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzcwNTM2Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MjMyMDQzNjQsImp0aSI6ImEwNTVkN2EyLTM0ZGUtNDM2NC1iYTU0LTJkYzZmNTdiOWQzNSJ9.ZqWH0G8gzViSUf7DdNHVF2YDH7m21Kkd4X74-Y0ObNw";
	@Autowired
	BankAPI bankAPI;

	@RequestMapping("/getAccountList")
	public List<String> getAccountList(HttpSession session, Model model) throws Exception {
		List<String> list = new ArrayList<String>();
		String user_num = "1100770536";
		Map<String, Object> map = bankAPI.getAccountList(access_token, user_num);
		System.out.println("map값 확인용" + map);
		List<String> result = (List<String>) map.get("user_name");
		for (String name : result) {
			list.add(name);
		}
		return list;
	}

}
