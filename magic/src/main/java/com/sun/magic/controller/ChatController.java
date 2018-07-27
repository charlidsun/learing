package com.sun.magic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.magic.utils.NetUtils;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月27日 上午11:47:44
 */
@RestController
public class ChatController {

	@GetMapping("/list")
	public String getM(){
		
		String d = NetUtils.getJsonData("https://mp.weixin.qq.com/cgi-bin/searchbiz?action=search_biz&token=672973593&lang=zh_CN&f=json&ajax=1&random=0.8808738231455555&query=%E4%B8%81%E9%A6%99%E5%9B%AD&begin=0&count=5");
		System.out.println(d);
		return "";
	}
}
