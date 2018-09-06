package com.sun.magic.test;

import java.io.IOException;

import com.sun.magic.constant.NetUrlConst;
import com.sun.magic.utils.NetUtils;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月28日 下午5:42:02
 */
public class Test {

	public static void main(String[] args) {
		trans();
	}
	
	public static void trans(){
		String val = "http://www.gotsoon.com/wangming/nvsheng/list1.html";
		System.out.println(val.substring(39,val.length()));
	}
}
