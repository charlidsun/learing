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
public class ImgOtherSpy implements PageProcessor {
	
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
		page.addTargetRequest("https://www.woyaogexing.com/"
				+ page.getHtml().xpath("//*[@id=\"main\"]/div[3]/div[1]/div[1]/div[3]/a[2]/@href"));
		
		List<String> indexList = page.getHtml().xpath("//*[@id=\"main\"]/div[3]/div[1]/div[1]/ul/li/a/img/@src").all();
		for (int i=0;i<indexList.size();i++) {
			System.out.println("http:"+indexList.get(i).toString());
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

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		
		
		//非主流
		Spider.create(new ImgOtherSpy()).addUrl("https://www.woyaogexing.com/touxiang/weixin/2018/609825.html")
		// 将爬取的结果放在目录的文件下
		// .addPipeline(new JsonFilePipeline("D:\\webmagic"))
				.thread(5).run();
	}

}
