package com.sun.nettyLearning.test;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
	
	private static Map<String,Object> map = new HashMap<>();
	
	public static void main(String[] args) {
		
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		System.err.println(map.toString());
		String key = getKeyByValue(map,"1");
		System.out.println(key);
		map.remove(key);
		System.out.println(map.toString());
	}
	
	
	public static String getKeyByValue(Map<String, Object> map, String value) {
		String resultKey = "";
		for (Map.Entry<String, Object> str : map.entrySet()) {
			if (value.equals(str.getValue())) {
				resultKey = str.getKey();
			}
		}
		return resultKey;
	}

}
