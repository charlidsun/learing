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
public class ChatSpy implements PageProcessor {

	// 引入service
	MoviesService moviesService = SpringUtil.getBean(MoviesService.class);
	// 爬取的基本信息
	String agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
			.setTimeOut(100000).setUserAgent(agent);
	
	@Override
	public void process(Page page) {
		//将翻页的链接添加到爬虫的引擎里
		//page.addTargetRequest("https://movie.douban.com/top250"
		//		+ page.getHtml().xpath("//span[@class='next']/a/@href"));
		//查出爬出的信息
		List<String> indexList = page.getHtml().xpath("//em/text()").all();
		List<String> linkList = page.getHtml().xpath("//ol[@class='grid_view']/li/div[@class='item']/div/a/@href").all();
		List<String> imgUrl = page.getHtml().xpath("//ol[@class='grid_view']/li/div[@class='item']/div/a/img/@src").all();
		List<String> title = page.getHtml().xpath("//ol[@class='grid_view']/li/div[@class='item']/div[@class='info']/div/a/span[1]/text()").all();
		List<String> actor = page.getHtml().xpath("//ol[@class='grid_view']/li/div[@class='item']/div[@class='info']/div/p/text()").all();
		List<String> rate = page.getHtml().xpath("//ol[@class='grid_view']/li/div[@class='item']/div[@class='info']/div/div/span[@class='rating_num']/text()").all();
		List<String> peoRate = page.getHtml().xpath("//ol[@class='grid_view']/li/div[@class='item']/div[@class='info']/div/div/span[4]/text()").all();
		List<String> intr = page.getHtml().xpath("//ol[@class='grid_view']/li/div[@class='item']/div[@class='info']/div/p/span/text()").all();
		for (int i = 0; i < indexList.size(); i++) {
			String linkListStr = linkList.get(i).toString();
			String imgUrlStr = imgUrl.get(i).toString();
			String titleStr = title.get(i).toString();
			String actorStr = actor.get(i).toString();
			String rateStr = rate.get(i).toString();
			String peoRateStr = peoRate.get(i).toString();
			String intrStr = intr.get(i).toString();
			Movies m = new Movies(i, linkListStr, imgUrlStr, titleStr, actorStr, rateStr, peoRateStr, intrStr);
			System.out.println(m.toString());
			//保存
			moviesService.save(m);
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new ChatSpy()).addUrl("https://movie.douban.com/top250")
		// 将爬取的结果放在目录的文件下
		// .addPipeline(new JsonFilePipeline("D:\\webmagic"))
				.thread(5).run();
	}

}
