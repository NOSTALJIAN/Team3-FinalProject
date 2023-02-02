package com.mulcam.SpringProject.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MapUtill {
	
	@Value("${naver.accessId}") private String accessId;	
	@Value("${naver.secretKey}") private String secretKey;
	
	// 유저의 주소를 위도와 경도 찾아주는 함수
	public List<Double> findLatLng(String document) throws Exception {
		List<Double> indexList = new ArrayList<Double>();
		String apiUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode";
		String query =  URLEncoder.encode(document, "utf-8");
		apiUrl += "?query=" + query;
		
		URL url = new URL(apiUrl);
		// 헤더 설정
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", accessId);
		conn.setRequestProperty("X-NCP-APIGW-API-KEY", secretKey);
		conn.setDoInput(true);
		
		// 응답 결과 확인
		int responseCode = conn.getResponseCode();
		
		// 데이터 수신
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		StringBuffer sb = new StringBuffer();
		String line = null;
		
		while((line = br.readLine()) != null)
			sb.append(line);
		br.close();
		
		// JSON 데이터에서 원하는 값 추출하기
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(sb.toString());
		JSONObject address = (JSONObject) ((JSONArray) object.get("addresses")).get(0);
		String lng_ = (String) address.get("x");
		String lat_ = (String) address.get("y");
		double lng = Float.parseFloat(lng_);
		double lat = Float.parseFloat(lat_);
		indexList.add(lat);
		indexList.add(lng);
		
		return indexList;
	}
	

}
