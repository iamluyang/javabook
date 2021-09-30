package online.javabook.jboss.netty.sample05.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class SampleWebSocketServer {
    public static void main(String[] args) throws Exception {

        EventLoopGroup masterGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(masterGroup, workerGroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    // 服务器基于http协议，使用http的编码和解码器
                    pipeline.addLast(new HttpServerCodec());

                    // 以块方式写，添加ChunkedWriteHandler处理器
                    pipeline.addLast(new ChunkedWriteHandler());

                    /**
                     * 1. http数据在传输过程中是分段的, HttpObjectAggregator可以将多个段聚合
                     * 2. 这就就是为什么，当浏览器发送大量数据时，就会发出多次http请求
                     */
                    pipeline.addLast(new HttpObjectAggregator(8192));

                    /**
                     * 1. websocket的数据是以帧(frame)的形式传递
                     * 2. WebSocketFrame下面有六个子类
                     * 3. 浏览器请求 ws://localhost:7000/xxx 表示请求ws的uri
                     * 4. WebSocketServerProtocolHandler的核心功能是将http协议升级为ws协议并保持长连接
                     * 5. ws协议切换会返回一个101的状态码
                     */
                    pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                    // 自定义的handler ，处理业务逻辑
                    pipeline.addLast(new SampleWebSocketFrameHandler());
                }
            });

            //启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();

        } finally {
            masterGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
