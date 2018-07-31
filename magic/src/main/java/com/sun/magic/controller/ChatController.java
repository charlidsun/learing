package com.sun.magic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.sun.magic.constant.NetUrlConst;
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

	private static String cookie = "RK=WXrpLjUgY+; ptcz=1ff39199b0b54048c09d396eca334332b97db7d62ae426cf958d0065f6e7acb1; pgv_pvi=1086202880; ptui_loginuin=751296025; pt2gguin=o0751296025; ua_id=eAPKJ4RFfVkOWMYfAAAAANw5mPYN6t0bzrib2Xu3Xy0=; mm_lang=zh_CN; pgv_si=s4725512192; uuid=7edf0f4131053d811e10e8b64f5f5ae3; ticket=0d6ca79c3cb268233d6d19a168ee885bd20d23de; ticket_id=gh_d7c05877c669; cert=2Fi9X3oaP4rCvqFqesm9dg8Ac_3ZghOH; noticeLoginFlag=1; data_bizuin=3247534487; bizuin=3244534398; data_ticket=5rpUg256MBeVSEJSLyA4olL6x4WJZK+Ewlan/iZPW0wUWbPyxbpQxzzd+xgntsFd; slave_sid=aFN2NWVzMHNpWjBJNk4xQVRQSkFlc181VENzM3BJeDREMTAydndhdTFwVFhvT001UWx6NEZRRk01b3ZoaUl5R2Y3NW9IbF95MzlUeEFfTzZFekVWMUdxRG5QUVlLdjJZczZPUGJMVWppaW1yeXJsUW1nOEJ6Nmd2dTBXa3RwS1hpclJMd002bVRaR0V5RUY2; slave_user=gh_d7c05877c669; xid=83a65c659c5563579cdf967415b0d3b2; openid2ticket_ol3GRwSxbJdVvHpL7f80T29MinjQ=Qx5tvQiLz8uG0sqjUXd+C2x0TqQbSO1NRKisHwvOnpo=";
	
	@Autowired
	RedisCacheService redisCacheService;

	@PostMapping("/searchChat")
	public String getSearchChat(String keyword, String begin, String count,
			Model model) {
		String chatStr = NetUtils.GetChat(
				NetUrlConst.getChatSearchUrl("1256316290", keyword, "0", "10"),
				cookie);
		System.out.println(NetUrlConst.getChatSearchUrl("1256316290", keyword, "0", "10"));
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
				NetUrlConst.getArticleUrl("1256316290", fakeId, "0", "10"),
				cookie);
		
		System.out.println(chatStr);
		
		model.addAttribute("name", value[1]);
		return "articleList";
	}
	
}
