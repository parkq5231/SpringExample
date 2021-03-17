package com.company.temp.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

	// 사용자 이름의 계좌 조회
	public Map<String, Object> getRealName(String access_Token, String user_num) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String reqURL = host + "/v2.0/inquiry/real_name";
		// 연결
		URL url = new URL(reqURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// post 요청
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		// 요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + access_Token);
		conn.setRequestProperty("scope", "oob");
		// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		StringBuilder sb = new StringBuilder();

		// parameter 수정
		sb.append("bank_tran_id=").append("M202111679U4BC34239Z")//
				.append("&bank_code_std=").append("097")//
				.append("&account_num=").append("1234567890123456")//
				.append("&account_holder_info_type=").append(" ")//
				.append("&account_holder_info=").append("880101")//
				.append("&tran_dtime=").append("20210317101921");//
		bw.write(sb.toString());
		bw.flush();
		// 출력되는 값이 200이면 정상작동
		int responseCode = conn.getResponseCode();
		System.out.println("responseCode : " + responseCode);
		// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
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
