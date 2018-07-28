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

	@Autowired
	RedisCacheService redisCacheService;

	@PostMapping("/searchChat")
	public String getSearchChat(String keyword, String begin, String count,
			Model model) {
		String cookie = "pgv_pvi=2510338048; _ga=GA1.2.2060100115.1529378160; pgv_pvid=563287400; pt2gguin=o0765970426; RK=TWrpPjUBac; ptcz=fb08d6f1207ee5bc3ae897b74e5ba1740b2967eb1840ca4acb88bd4f8569230f; ua_id=4I19jxMMj2diFYPcAAAAANDBW_2WC2y4qf_8FXQnSII=; mm_lang=zh_CN; noticeLoginFlag=1; o_cookie=765970426; pac_uid=1_765970426; tvfe_boss_uuid=e0a07dd29593418c; AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17726%7CMCMID%7C66100023919907103941143036901107031827%7CMCAAMLH-1532070553%7C11%7CMCAAMB-1532070553%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1531472953s%7CNONE%7CMCSYNCSOP%7C411-17733%7CMCAID%7CNONE%7CvVersion%7C2.4.0; remember_acct=jntongbang%40yeah.net; rewardsn=; wxtokenkey=777; pgv_si=s4954391552; uuid=6e6d3587241853c0bed83d4d7b04510a; ticket=eab98bb3bca233e55688beb12dfdc1093302a7fc; ticket_id=gh_d7c05877c669; cert=qEFKRsCinWh9Tt7RpirkXpH0087hx6o5; data_bizuin=3247534487; bizuin=3244534398; data_ticket=NB6Q+lfT8GMKtpCNcF4csC6kPVMMl456ZTBeL8Mr3bRuzPqTpl+WBFWb4cISq/yX; slave_sid=RldqR29xaE5EU1J4MnJJWXNCdlpVOEZTdGRYd1RmOWhCYWNjeWNXTWtGUUdLa1cwRWFtcEtvWklCc0FmdXE4czFXaWxLaDdYekw2bFZhX3FqOVdhQnVoZU9qN2VWMVpNSkJTQ3N3SWQ3N2E2aFNYaEV1Z2J5VHl5ZnRMeUNpd3Y5YTN5OGIzQ3hIUktyUHJq; slave_user=gh_d7c05877c669; xid=7cda6d1596be12517f435269c41c4b04; openid2ticket_ol3GRwSxbJdVvHpL7f80T29MinjQ=KfrS2ht35ytoMAImUlzPD/3JpjxxexhIGoTAWe0clVY=";
		String chatStr = NetUtils.GetChat(
				NetUrlConst.getChatSearchUrl("1252407792", keyword, "0", "10"),
				cookie);
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
}
