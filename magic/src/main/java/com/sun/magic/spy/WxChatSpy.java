package com.sun.magic.spy;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import com.sun.magic.config.SpringUtil;
import com.sun.magic.domain.Movies;
import com.sun.magic.service.MoviesService;

/**
 * 功能：爬虫类 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月26日 下午1:30:21
 */
public class WxChatSpy implements PageProcessor {

	// 爬取的基本信息
	String agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
			.setTimeOut(100000).setUserAgent(agent);
	
	@Override
	public void process(Page page) {
		System.err.println(page.getHtml().toString());
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new WxChatSpy()).addUrl("https://mp.weixin.qq.com/cgi-bin/searchbiz?action=search_biz&token=1252407792&lang=zh_CN&f=json&ajax=1&random=0.8808738231455555&query=丁香园&begin=0&count=5").thread(5).run();
	}

}
