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
		try {
			MyHttpUrlConn.Get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
