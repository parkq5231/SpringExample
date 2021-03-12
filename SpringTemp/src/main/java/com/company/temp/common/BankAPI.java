package com.company.temp.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class BankAPI {
	String host = "https://testapi.openbanking.or.kr";
	String client_id = "a61c3366-5f48-421e-a297-56620fedd3e6";
	String client_secret = "0bdfc679-8a58-435d-a41f-c12a6bf411c0";
	String redirect_uri = "http://localhost/bank2/callback";
	// 이용기관코드
	String user_ord_code = "M202111679";

	// 사용자 정보 get
	public Map<String, Object> getAccountList(String access_Token, String user_num) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String reqURL = host + "/v2.0/account/list";

		StringBuilder qstr = new StringBuilder();
		qstr.append("user_seq_no=" + user_num)//
				.append("&include_cancel_yn=Y")//
				.append("&sort_order=D");
		// 연결
		URL url = new URL(reqURL + "?" + qstr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		// 요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + access_Token);
		// 출력되는 값이 200이면 정상작동
		int responseCode = conn.getResponseCode();
		System.out.println("responseCode : " + responseCode);

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = "";
		String result = "";

		while ((line = br.readLine()) != null) {
			result += line;
		}
		System.out.println("response body : " + result);
		// map에 담아 리턴
		Gson gson = new Gson();
		map = gson.fromJson(result, Map.class);
		return map;
	}
}
