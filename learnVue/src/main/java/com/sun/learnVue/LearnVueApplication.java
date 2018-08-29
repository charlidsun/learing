package com.sun.learnVue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class LearnVueApplication {
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Stu> list = new ArrayList<Stu>();
		list.add(new Stu("cccc", "dddd"));
		list.add(new Stu("aaaa", "bbbbb"));
		model.addAttribute("name", "FootBall");
		model.addAttribute("players",list);
		return "index";
	}
	
	@GetMapping("/element")
	public String element(Model model) {
		List<Stu> list = new ArrayList<Stu>();
		list.add(new Stu("cccc", "dddd"));
		list.add(new Stu("aaaa", "bbbbb"));
		model.addAttribute("name", "FootBall");
		model.addAttribute("players",list);
		return "element";
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnVueApplication.class, args);
	}
}
