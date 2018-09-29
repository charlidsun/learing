package com.sun.magic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.sun.magic.constant.NetUrlConst;
import com.sun.magic.domain.article.ArticelBean;
import com.sun.magic.domain.chat.Root;
import com.sun.magic.service.RedisCacheService;
import com.sun.magic.utils.NetUtils;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月27日 上午11:47:44
 */
@Controller
@RequestMapping("/chat")
public class ChatController {

	private static String cookie = "pgv_pvi=2510338048; _ga=GA1.2.2060100115.1529378160; pgv_pvid=563287400; pt2gguin=o0765970426; RK=TWrpPjUBac; ptcz=fb08d6f1207ee5bc3ae897b74e5ba1740b2967eb1840ca4acb88bd4f8569230f; ua_id=4I19jxMMj2diFYPcAAAAANDBW_2WC2y4qf_8FXQnSII=; mm_lang=zh_CN; o_cookie=765970426; pac_uid=1_765970426; tvfe_boss_uuid=e0a07dd29593418c; AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17726%7CMCMID%7C66100023919907103941143036901107031827%7CMCAAMLH-1532070553%7C11%7CMCAAMB-1532070553%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1531472953s%7CNONE%7CMCSYNCSOP%7C411-17733%7CMCAID%7CNONE%7CvVersion%7C2.4.0; eas_sid=w1r5x3b3k7b0C1E9j7d1M6L5d0; noticeLoginFlag=1; uin=o0765970426; skey=@2GcW5HBvK; ptisp=cnc; pgv_si=s4584514560; uuid=6507a10c2362e70cc3ba71a03a502741; ticket=92cd02b75b04cb1d0e85dabdd5894e3bd78b6c54; ticket_id=gh_d7c05877c669; cert=yN_5OVGWsliZ7is5iXu_DhIDDqpXR_WM; data_bizuin=3247534487; bizuin=3244534398; data_ticket=0m9TQKn4rgFsJ+hYiuoOUq/SowVRdEqCYmjnyCGpMqkIrQSUC3qldNdDLjE1/U6h; slave_sid=Z0ZuYXlzZW9EQ1oyU1NkWktrT0VBSFRVcWx0VUZYNlZ6T1BfWkRlUWV2TUx6RHF0UTJvM1ptaW04SGNkUzJiVEVCamhkRk02cV9CWnRyQ2QzbEVObFFTQkhoWnpGbmlKcDFwb3FuTHR1YThoOWlYN1cwMGt5azlKZFozM3hGRUt3T2JEdm1oY2xScGtDUzVI; slave_user=gh_d7c05877c669; xid=6a673d47c7c64a7922e3bd76c0bd7984; openid2ticket_ol3GRwSxbJdVvHpL7f80T29MinjQ=ME6nUEHRSvasz+2FE0Wo6TamuRuJEhnY7hI8Wk8SYJw=";
	@Autowired
	RedisCacheService redisCacheService;

	@PostMapping("/searchChat")
	public String getSearchChat(String keyword, String begin, String count,
			Model model) {
		String chatStr = NetUtils.GetChat(
				NetUrlConst.getChatSearchUrl("1513109062", keyword, "0", "10"),
				cookie);
		System.out.println(NetUrlConst.getChatSearchUrl("609356543", keyword, "0", "10"));
		System.out.println(chatStr);
		JSONObject object = JSONObject.parseObject(chatStr);
		Root root = (Root) JSONObject.toJavaObject(object, Root.class);
		//判断请求是否成功
		if (root.getBase_resp().getRet() != 0){
			model.addAttribute("token", "token失效，请重新添加");
			return "index";
		}
		//将查出来的数据传递给下一个页面
		model.addAttribute("list",root.getList());
		model.addAttribute("total", root.getTotal());
		return "list";
	}
	
	
	@PostMapping("/searchArticle")
	public String getArticle(String keyword, String begin, String count,
			Model model){
		//keyword是一个字符串，包含基本信息
		String[] value = keyword.split("$");
		System.out.println(keyword);
		String fakeId = value[0];
		
		//调用接口
		String chatStr = NetUtils.GetChat(
				NetUrlConst.getArticleUrl("609356543", fakeId, "0", "10"),
				cookie);
		
		System.out.println(chatStr);
		JSONObject object = JSONObject.parseObject(chatStr);
		ArticelBean root = (ArticelBean) JSONObject.toJavaObject(object, ArticelBean.class);
		//判断请求是否成功
		if (root.getBase_resp().getRet() != 0){
			model.addAttribute("token", "token失效，请重新添加");
			return "index";
		}
		model.addAttribute("name", value[1]);
		model.addAttribute("list", root.getApp_msg_list());
		return "articleList";
	}
	
}
