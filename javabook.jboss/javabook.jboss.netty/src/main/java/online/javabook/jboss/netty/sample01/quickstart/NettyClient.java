package online.javabook.jboss.netty.sample01.quickstart;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;

public class NettyClient {
    public static void main(String[] args) throws Exception {

        // 客户端需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建客户端的启动对象
            Bootstrap bootstrap = new Bootstrap();

            // 设置客户端启动器线程组
            bootstrap.group(group)
                    // 设置客户端通道的实现类
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                            socketChannel.pipeline().addLast(new LoggingHandler());
                        }
                    });
            System.out.println("初始化客户端结束[OK]");

            // 客户端异步连接服务器端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999).sync();
            System.out.println("客户端连接服务器[OK]");

            // 监听客户端通道关闭进行
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
