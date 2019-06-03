package com.sun;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestFq {

    public static void main(String[] args) throws Exception{
        //飞秋的数据格式
        String str="1:100:sunjingge:macbook:32:服务器出现异常，请马上解决。";
        byte[] array=str.getBytes("gbk");
        //发送的管道
        DatagramSocket ds=new DatagramSocket();
        //数据包
        DatagramPacket dp=new DatagramPacket(array, array.length,InetAddress.getByName("127.0.0.1"),2425);
        //ds.send(dp);
        while(true){
            ds.send(dp);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
