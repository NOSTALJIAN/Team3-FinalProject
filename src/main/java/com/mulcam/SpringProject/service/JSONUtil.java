package com.mulcam.SpringProject.service;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONUtil {
	@SuppressWarnings({"unchecked"})
	public String stringify(List<String> list) {
		JSONObject obj = new JSONObject();
		obj.put("list", list);
		return obj.toString();
	}
	
	@SuppressWarnings({"unchecked"})
	public List<String> parse(String jsonStr) {
		JSONParser parser = new JSONParser(jsonStr);
		List<String> list = null;
		if (jsonStr == null || jsonStr.equals("")) 
			return list;
		try {
			JSONObject jsonList = (JSONObject) parser.parse();
			JSONArray jsonArr = (JSONArray) jsonList.get("list");
			list = (List<String>) jsonArr;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return list;
	}
}
