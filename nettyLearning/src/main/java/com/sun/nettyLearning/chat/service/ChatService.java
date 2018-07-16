package com.sun.nettyLearning.chat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.nettyLearning.chat.entity.ChatHistory;
import com.sun.nettyLearning.dbDao.DbDao;
import com.sun.nettyLearning.utils.TransUtils;

@Service
public class ChatService {

	@Autowired
	DbDao dbDao;
	
	public List<ChatHistory> getListChatHistory(String sendUserId,String receiveUserId){
		
		String sql = " SELECT "
						+" ch.id,ch.sendUserId,de.userName sendUserName,ch.receiveUserId, "
						+" dee.userName receiveUserName,ch.content,ch.create_time,de.headImg sendUserImg,dee.headImg receiveUserImg "
						+" FROM"
						+" chathistory ch "
						+" LEFT JOIN userlogin lo on ch.sendUserId = lo.loginName "
						+" LEFT JOIN userlogin loo on ch.receiveUserId = loo.loginName "
						+" LEFT JOIN userdetails de on de.id = lo.id "
						+" LEFT JOIN userdetails dee on dee.id = loo.id "
						+" WHERE "
						+" (ch.sendUserId = '"+sendUserId+"' AND ch.receiveUserId = '"+receiveUserId+"') "
						+" or "
						+" (ch.sendUserId = '"+receiveUserId+"' AND ch.receiveUserId = '"+sendUserId+"') "
						+" ORDER BY create_time DESC LIMIT 20 ";
		List<Map<String,Object>> list = dbDao.queryListMap(sql);
		List<ChatHistory> chatList = null;
		try {
			chatList = TransUtils.listMapToList(list, ChatHistory.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chatList;
	}
	
	public int saveChatHistory(Map<String,Object> chatMap) {
		String sql = TransUtils.mapToInsertSql(chatMap, "chathistory");
		System.out.println(sql);
		return dbDao.exceSql(sql);
	}
	
}
