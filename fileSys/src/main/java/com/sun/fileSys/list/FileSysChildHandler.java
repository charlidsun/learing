package com.sun.fileSys.list;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月23日 下午5:13:25
 */
public class FileSysChildHandler extends ChannelInitializer<SocketChannel>{

	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		ChannelPipeline cp = ch.pipeline();
		//解码
		cp.addLast("http-decoder",new HttpRequestDecoder());
		//聚合
		cp.addLast("http-aggregator",new HttpObjectAggregator(65536));
        // 编码
		cp.addLast("http-encoder", new HttpResponseEncoder());
        // 新增Chunked handler，主要作用是支持异步发送大的码流（例如大文件传输）
        // 但是不占用过多的内存，防止发生java内存溢出错误
		cp.addLast("http-chunked", new ChunkedWriteHandler());
        // HttpFileServerHandler用于文件服务器的业务逻辑处理
		cp.addLast("fileServerHandler", new HttpFileServerHandler());
	}

}
