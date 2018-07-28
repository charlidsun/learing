/**  
* 功能:  
* 说明:  
* @author 孙荆阁  
* @date 2018年7月28日    
*/ 
package com.sun.magic.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月28日 下午5:45:36
 */
/**
 * @author Administrator
 *
 */
class MyHttpUrlConn {
    public static String cookieVal="";
    public static String cookie="pgv_pvi=2510338048; _ga=GA1.2.2060100115.1529378160; pgv_pvid=563287400; pt2gguin=o0765970426; RK=TWrpPjUBac; ptcz=fb08d6f1207ee5bc3ae897b74e5ba1740b2967eb1840ca4acb88bd4f8569230f; ua_id=4I19jxMMj2diFYPcAAAAANDBW_2WC2y4qf_8FXQnSII=; mm_lang=zh_CN; noticeLoginFlag=1; o_cookie=765970426; pac_uid=1_765970426; tvfe_boss_uuid=e0a07dd29593418c; AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17726%7CMCMID%7C66100023919907103941143036901107031827%7CMCAAMLH-1532070553%7C11%7CMCAAMB-1532070553%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1531472953s%7CNONE%7CMCSYNCSOP%7C411-17733%7CMCAID%7CNONE%7CvVersion%7C2.4.0; remember_acct=jntongbang%40yeah.net; rewardsn=; wxtokenkey=777; pgv_si=s4954391552; uuid=6e6d3587241853c0bed83d4d7b04510a; ticket=eab98bb3bca233e55688beb12dfdc1093302a7fc; ticket_id=gh_d7c05877c669; cert=qEFKRsCinWh9Tt7RpirkXpH0087hx6o5; data_bizuin=3247534487; bizuin=3244534398; data_ticket=NB6Q+lfT8GMKtpCNcF4csC6kPVMMl456ZTBeL8Mr3bRuzPqTpl+WBFWb4cISq/yX; slave_sid=RldqR29xaE5EU1J4MnJJWXNCdlpVOEZTdGRYd1RmOWhCYWNjeWNXTWtGUUdLa1cwRWFtcEtvWklCc0FmdXE4czFXaWxLaDdYekw2bFZhX3FqOVdhQnVoZU9qN2VWMVpNSkJTQ3N3SWQ3N2E2aFNYaEV1Z2J5VHl5ZnRMeUNpd3Y5YTN5OGIzQ3hIUktyUHJq; slave_user=gh_d7c05877c669; xid=7cda6d1596be12517f435269c41c4b04; openid2ticket_ol3GRwSxbJdVvHpL7f80T29MinjQ=KfrS2ht35ytoMAImUlzPD/3JpjxxexhIGoTAWe0clVY=";
 
    public static String Get() throws IOException  {
        URL getUrl = new URL("https://mp.weixin.qq.com/cgi-bin/searchbiz?action=search_biz&token=1252407792&lang=zh_CN&f=json&ajax=1&random=0.8808738231455555&query=%E4%B8%81%E9%A6%99%E5%9B%AD&begin=0&count=5");
        HttpURLConnection connection = (HttpURLConnection) getUrl
                .openConnection();
        connection.setRequestProperty("Cookie", cookie);
        connection.connect();
        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(),"UTF-8"));
        System.out.println("Contents of get request:");
        String lines;
        while ((lines = reader.readLine()) != null)  {
             System.out.println(lines);
        }
       
        reader.close();
        // 断开连接
        connection.disconnect();
        return lines;
    }
 
    public static String Post(String url_post,String str_param_body,String charset,boolean b_flag,String cookies) throws IOException  {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(url_post);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl
                .openConnection();
        // Output to the connection. Default is
        // false, set to true because post
        // method must write something to the
        // connection
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        if("" != cookies){
            connection.setRequestProperty("Cookie", cookies);
        }
 
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // Set the post method. Default is GET
        connection.setRequestMethod("POST");
        // Post cannot use caches
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        // This method takes effects to
        // every instances of this class.
        // URLConnection.setFollowRedirects是static函数，作用于所有的URLConnection对象。
        // connection.setFollowRedirects(true);
 
        // This methods only
        // takes effacts to this
        // instance.
        // URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
        connection.setInstanceFollowRedirects(b_flag);
        // Set the content type to urlencoded,
        // because we will write
        // some URL-encoded content to the
        // connection. Settings above must be set before connect!
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection
                .getOutputStream());
        // The URL-encoded contend
        // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
        //    String content = "userName=" + URLEncoder.encode("console", "utf-8");
        //    content = content + "&password=" + URLEncoder.encode("12345678", "utf-8");
 
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
        out.writeBytes(str_param_body);
 
        out.flush();
 
        // 取得cookie，相当于记录了身份，供下次访问时使用
        //    cookieVal = connection.getHeaderField("Set-Cookie").split(";")[0]
        cookieVal = connection.getHeaderField("Set-Cookie");
 
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(),charset));
        String line;
        System.out.println("Contents of post request:");
        while ((line = reader.readLine()) != null)  {
            System.out.println(line);
        }
 
        reader.close();
        connection.disconnect();
 
        return cookieVal;
    }
}