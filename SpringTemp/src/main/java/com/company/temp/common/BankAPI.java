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
	public String getRealName(String access_Token) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String reqURL = host + "/v2.0/inquiry/real_name";
		// 연결
		URL url = new URL(reqURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// post 요청
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

		// 요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + access_Token);
		// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		Map sb = new HashMap<>();

		// parameter 수정
		sb.put("bank_tran_id", "M202111679U" + getRand());//
		sb.put("bank_code_std", "097");//
		sb.put("account_num", "1234567890123456");//
		sb.put("account_holder_info_type", " ");//
		sb.put("account_holder_info", "880101");//
		sb.put("tran_dtime", "20210317101921");//

		Gson gson = new Gson();
		String json = gson.toJson(sb);
		bw.write(json);
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

		return result;
	}

	// 난수
	// 9자리 난수
	public String getRand() {
		long time = System.currentTimeMillis();
		String str = Long.toString(time);
		return str.substring(str.length() - 9);// 9자리 이후로 자름?
	}

}
