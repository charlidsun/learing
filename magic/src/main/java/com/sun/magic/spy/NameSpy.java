package com.sun.magic.spy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sun.magic.domain.MyHead;
import com.sun.magic.jdbc.JdbcUtilss;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 功能：爬虫类 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月26日 下午1:30:21
 */
public class NameSpy implements PageProcessor {

	Connection connection = null;
	Statement statement = null;

	// 爬取的基本信息
	String agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(100000).setUserAgent(agent);

	@Override
	public void process(Page page) {

		// 获取数据库链接对象
		connection = JdbcUtilss.getConnection();

		// 将下一页加进去
		page.addTargetRequest(""+(page.getHtml().xpath("//ul/li[@class='page pagetex'][2]/a/@href")));
		
		System.out.println(page.getHtml().xpath("//ul/li[@class='page pagetex'][2]/a/@href"));
		

		List<String> indexList = page.getHtml().xpath("/html/body/div/div[1]/div/ul[1]/li[@class]/a/text()").all();

		for (int i = 0; i <indexList.size(); i++) {
			// 获取数据执行方法
			try {
				String sql = "INSERT INTO `learning`.`myname` (`name`) VALUES ('"+indexList.get(i).toString()+"')";
				statement = connection.createStatement();
				statement.execute(sql);

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {

		// 要爬取的网页
		Spider.create(new NameSpy()).addUrl("http://www.gotsoon.com/wangming/nvsheng/list179.html")
				// 将爬取的结果放在目录的文件下
				.addPipeline(new JsonFilePipeline("D:\\webmagic")).thread(5).run();
	}

}
