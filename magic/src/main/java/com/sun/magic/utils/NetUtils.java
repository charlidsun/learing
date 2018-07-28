package com.sun.magic.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

/**
 * 功能：访问网络的工具类 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月27日 上午11:03:52
 */
public class NetUtils {

	public static String getJsonData(String urls) {
		StringBuffer sb = new StringBuffer();
		String cookie = "pgv_pvi=2510338048; _ga=GA1.2.2060100115.1529378160; pgv_pvid=563287400; pt2gguin=o0765970426; RK=TWrpPjUBac; ptcz=fb08d6f1207ee5bc3ae897b74e5ba1740b2967eb1840ca4acb88bd4f8569230f; ua_id=4I19jxMMj2diFYPcAAAAANDBW_2WC2y4qf_8FXQnSII=; mm_lang=zh_CN; noticeLoginFlag=1; o_cookie=765970426; pac_uid=1_765970426; tvfe_boss_uuid=e0a07dd29593418c; AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17726%7CMCMID%7C66100023919907103941143036901107031827%7CMCAAMLH-1532070553%7C11%7CMCAAMB-1532070553%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1531472953s%7CNONE%7CMCSYNCSOP%7C411-17733%7CMCAID%7CNONE%7CvVersion%7C2.4.0; remember_acct=jntongbang%40yeah.net; rewardsn=; wxtokenkey=777; pgv_si=s4954391552; uuid=6e6d3587241853c0bed83d4d7b04510a; ticket=eab98bb3bca233e55688beb12dfdc1093302a7fc; ticket_id=gh_d7c05877c669; cert=qEFKRsCinWh9Tt7RpirkXpH0087hx6o5; data_bizuin=3247534487; bizuin=3244534398; data_ticket=NB6Q+lfT8GMKtpCNcF4csC6kPVMMl456ZTBeL8Mr3bRuzPqTpl+WBFWb4cISq/yX; slave_sid=RldqR29xaE5EU1J4MnJJWXNCdlpVOEZTdGRYd1RmOWhCYWNjeWNXTWtGUUdLa1cwRWFtcEtvWklCc0FmdXE4czFXaWxLaDdYekw2bFZhX3FqOVdhQnVoZU9qN2VWMVpNSkJTQ3N3SWQ3N2E2aFNYaEV1Z2J5VHl5ZnRMeUNpd3Y5YTN5OGIzQ3hIUktyUHJq; slave_user=gh_d7c05877c669; xid=7cda6d1596be12517f435269c41c4b04; openid2ticket_ol3GRwSxbJdVvHpL7f80T29MinjQ=KfrS2ht35ytoMAImUlzPD/3JpjxxexhIGoTAWe0clVY=";
		try {
			// 创建url资源
			URL url = new URL(urls);
			// 建立http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置允许输入
			conn.setDoInput(true);
			// 设置不用缓存
			// 设置传递方式
			conn.setRequestMethod("GET");
			//设置cookier
			conn.setRequestProperty("Cookie", cookie);
			conn.setDoInput(true);
			// 开始连接请求
			conn.connect();
			OutputStream out = new DataOutputStream(conn.getOutputStream());
			// 写入请求的字符串
			out.flush();
			out.close();

			// 请求返回的状态
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				// 请求返回的数据
				InputStream in1 = conn.getInputStream();
				try {
					String readLine = new String();
					BufferedReader responseReader = new BufferedReader(
							new InputStreamReader(in1, "UTF-8"));
					while ((readLine = responseReader.readLine()) != null) {
						sb.append(readLine).append("\n");
					}
					responseReader.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
			}

		} catch (Exception e) {

		}

		return sb.toString();

	}
	public static String getJsonData(JSONObject jsonParam, String urls) {
		StringBuffer sb = new StringBuffer();
		try {
			// 创建url资源
			URL url = new URL(urls);
			// 建立http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置允许输出
			conn.setDoOutput(true);
			// 设置允许输入
			conn.setDoInput(true);
			// 设置不用缓存
			conn.setUseCaches(false);
			// 设置传递方式
			conn.setRequestMethod("POST");
			// 设置维持长连接
			conn.setRequestProperty("Connection", "Keep-Alive");
			// 设置文件字符集:
			conn.setRequestProperty("Charset", "UTF-8");
			// 转换为字节数组
			byte[] data = (jsonParam.toString()).getBytes();
			// 设置文件长度
			conn.setRequestProperty("Content-Length",
					String.valueOf(data.length));
			// 设置文件类型:
			conn.setRequestProperty("contentType", "application/json");
			// 开始连接请求
			conn.connect();
			OutputStream out = new DataOutputStream(conn.getOutputStream());
			// 写入请求的字符串
			out.write((jsonParam.toString()).getBytes());
			out.flush();
			out.close();
			
			// 请求返回的状态
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				// 请求返回的数据
				InputStream in1 = conn.getInputStream();
				try {
					String readLine = new String();
					BufferedReader responseReader = new BufferedReader(
							new InputStreamReader(in1, "UTF-8"));
					while ((readLine = responseReader.readLine()) != null) {
						sb.append(readLine).append("\n");
					}
					responseReader.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
			}
			
		} catch (Exception e) {
			
		}
		
		return sb.toString();
		
	}
	
	public static String GetChat(String urls,String cookie) {
		String lines="";
		try {
			URL getUrl = new URL(urls);
	        HttpURLConnection connection = (HttpURLConnection) getUrl
	                .openConnection();
	        connection.setRequestProperty("Cookie", cookie);
	        connection.connect();
	        // 取得输入流，并使用Reader读取
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                connection.getInputStream(),"UTF-8"));
	       
	        while ((lines = reader.readLine()) != null)  {
	        }
	        reader.close();
	        // 断开连接
	        connection.disconnect();
		} catch (Exception e) {
		}
        return lines;
    }
}
