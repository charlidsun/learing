package com.sun.fileSys.list;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月23日 下午5:19:59
 */
public class HttpFileServerHandler extends
		SimpleChannelInboundHandler<FullHttpRequest> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg)
			throws Exception {

		// 打印请求过来值
		System.err.println(msg);
		System.err.println(msg.uri());
		String uri = msg.uri();
		// 访问小图标
		if (uri.equals("/favicon.ico")) {
			return;
		}
		// 先解码
		if (!msg.decoderResult().isSuccess()) {
			System.out.println("错误的请求");
			return;
		}
		// 过滤请求方法
		if (msg.method() != HttpMethod.GET) {
			System.out.println("请使用get请求");
		}
		//
		final String path = sanitizeUri(uri);

	}

	private String sanitizeUri(String uri) {
		try {
			// 使用JDK的URLDecoder进行解码
			uri = URLDecoder.decode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			try {
				uri = URLDecoder.decode(uri, "ISO-8859-1");
			} catch (UnsupportedEncodingException e1) {
				throw new Error();
			}
		}
		// URL合法性判断
		if (!uri.startsWith(FileSysServer.url)) {
			return null;
		}
		if (!uri.startsWith("/")) {
			return null;
		}
		return null;
		// 将硬编码的文件路径
//		uri = uri.replace('/', File.separatorChar);
//		if (uri.contains(File.separator + '.')
//				|| uri.contains('.' + File.separator) || uri.startsWith(".")
//				|| uri.endsWith(".") || INSECURE_URI.matcher(uri).matches()) {
//			return null;
//		}
//		return System.getProperty("user.dir") + File.separator + uri;
	}

}
