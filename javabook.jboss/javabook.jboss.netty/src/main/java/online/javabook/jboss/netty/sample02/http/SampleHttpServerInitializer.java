package online.javabook.jboss.netty.sample02.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class SampleHttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        //得到管道
        ChannelPipeline pipeline = ch.pipeline();

        // 1. HttpServerCodec 是netty 提供的处理http的编-解码器
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());

        //2. 增加一个自定义的handler
        pipeline.addLast("SampleHttpServerHandler", new SampleHttpServerHandler());
    }
}
