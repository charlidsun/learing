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
public class ImgSpy implements PageProcessor {
	
	Connection connection = null;
	Statement statement = null;
	
	// 爬取的基本信息
	String agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
			.setTimeOut(100000).setUserAgent(agent);
	
	@Override
	public void process(Page page) {
		
		
		//获取数据库链接对象
		connection = JdbcUtilss.getConnection();
		
		//将下一页加进去
		page.addTargetRequest("http://www.qqw21.com/"
				+ page.getHtml().xpath("//*[@id=\"NextPageText\"]/var/dfn/a/@href"));
		
		if (page.getUrl().toString().indexOf("index") > 0) {
			
			List<String> list = page.getHtml().xpath("/html/body/div[2]/div[5]/div/div[3]/div/div[1]/ul/li/a/@href").all();
			for (int i=0;i<list.size();i++) {
				//将详情页加进去
				page.addTargetRequest("http://www.qqw21.com/"
						+list.get(i));
			}
		}
		
		if (page.getUrl().toString().indexOf("index") == -1) {
			List<String> indexList = page.getHtml().xpath("/html/body/div[2]/div[5]/div/div[3]/div/div[2]/div[3]/p[3]/img/@src").all();
			for (int i=0;i<indexList.size();i++) {
				//获取数据执行方法
				try {
					statement = connection.createStatement();
					statement.execute("INSERT INTO myimg (img) VALUES ('"+indexList.get(i)+"')");
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
				}
			}
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		
		
		//非主流
		Spider.create(new ImgSpy()).addUrl("http://www.qqw21.com/feizhuliutouxiang/index-1.html")
		// 将爬取的结果放在目录的文件下
		 .addPipeline(new JsonFilePipeline("D:\\webmagic"))
				.thread(5).run();
	}

}
