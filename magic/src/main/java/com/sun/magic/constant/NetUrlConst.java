package com.sun.magic.constant;

import org.springframework.stereotype.Repository;

import com.sun.magic.config.SpringUtil;
import com.sun.magic.service.RedisCacheService;


/**
 * 功能：获取微信接口
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月27日 下午1:02:58
 */
public class NetUrlConst {
	
	//搜索微信公众号
	private static final String CHAT_SEARCH_URL ="https://mp.weixin.qq.com/cgi-bin/searchbiz?action=search_biz&lang=zh_CN&f=json&ajax=1&random=0.8808738231455555";
	RedisCacheService redisCacheService = SpringUtil.getBean(RedisCacheService.class);
	
	public static String getChatSearchUrl(String token,String query,String begin,String count){
		String param = "&token="+token+"&query="+query+"&begin="+begin+"&count="+count;
		return CHAT_SEARCH_URL + param;
	}

	//根据微信公众号查找文章列表
	public static final String CHAT_ARTICLE_URL = "https://mp.weixin.qq.com/cgi-bin/appmsg?lang=zh_CN&f=json&ajax=1&random=0.6552732620295874&action=list_ex&query=&type=9";
	
	public static String getArticleUrl(String token,String fakeId,String begin,String count){
		String param = "&token="+token + "&fakeid="+fakeId+"%3D%3D&begin="+begin+"&count="+count;
		return CHAT_ARTICLE_URL + param;
	}

	

}
