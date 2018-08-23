package com.sun.learnVue.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.learnVue.home.service.HomeService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	HomeService homeService;
	
	@GetMapping
	public String getBannerList(Model model){
		List<Map<String,Object>> bannerList = new ArrayList<>();
		bannerList = homeService.getBannerList();
		
		model.addAttribute("banner", bannerList);
		return "index";
	}
}
