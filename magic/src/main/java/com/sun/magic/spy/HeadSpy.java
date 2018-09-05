package com.sun.magic.spy;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
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
public class HeadSpy implements PageProcessor {

	// 爬取的基本信息
	String agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(100000).setUserAgent(agent);

	@Override
	public void process(Page page) {
		// 将翻页的链接添加到爬虫的引擎里
		page.addTargetRequest("http://www.qqw21.com/"
				+ page.getHtml().xpath("/html/body/div[2]/div[5]/div/div[3]/div/div/ul/li/a/@href"));
		// 查出爬出的信息
		List<String> indexList = page.getHtml()
				.xpath("/html/body/div[2]/div[5]/div/div[3]/div/div[2]/div[3]/p[3]/img/@src").all();
		for (int i = 0; i < indexList.size(); i++) {
			System.out.println(indexList.get(i));
		}

	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new HeadSpy()).addUrl("http://www.qqw21.com/")
				// 将爬取的结果放在目录的文件下
				.addPipeline(new JsonFilePipeline("D:\\webmagic")).thread(5).run();
	}

}
