package com.sun.nettyLearning.test;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
	
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		String userId = "";
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (!entry.getKey().equals("a")) {
				userId += "'" +entry.getValue() +"',";
			}
		}
		System.err.println(userId.substring(0,userId.length()-1));
	}

}
