package com.sun.magic.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
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
			conn.setRequestMethod("GET");
			// 设置维持长连接
			conn.setRequestProperty("Connection", "Keep-Alive");
			// 设置文件字符集:
			conn.setRequestProperty("Charset", "UTF-8");
			// 设置文件类型:
			conn.setRequestProperty("contentType", "application/json");
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
}
