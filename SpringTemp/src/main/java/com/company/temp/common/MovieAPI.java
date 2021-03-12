package com.company.temp.common;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieAPI {
	public Map moviedirectors() {
		String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=20205144";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, Map.class);
	}
}
