package com.sun.magic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import us.codecraft.webmagic.Spider;

import com.sun.magic.domain.Movies;
import com.sun.magic.service.MoviesService;
import com.sun.magic.spy.ChatSpy;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月26日 下午1:38:37
 */
@RestController
@RequestMapping("/movie")
public class MoviesController {

	@Autowired
	MoviesService moviesService;

	@PostMapping
	public int save(@ModelAttribute Movies movies) {
		Spider.create(new ChatSpy()).addUrl("https://movie.douban.com/top250")
		// 将爬取的结果放在目录的文件下
		// .addPipeline(new JsonFilePipeline("D:\\webmagic"))
				.thread(5).run();
		return 1;
	}

}
