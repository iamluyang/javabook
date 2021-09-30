package online.javabook.jboss.netty.sample07.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class SampleHeartServer {
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
                    /**加入一个netty 提供 IdleStateHandler
                    1. IdleStateHandler是netty提供的处理空闲状态的处理器
                    2. long readerIdleTime : 表示多长时间没有读, 就会发送一个心跳检测包检测是否连接
                    3. long writerIdleTime : 表示多长时间没有写, 就会发送一个心跳检测包检测是否连接
                    4. long allIdleTime    : 表示多长时间没有读写, 就会发送一个心跳检测包检测是否连接
                    5. 当 IdleStateEvent触发后, 就会传递给管道的下一个handler去处理userEventTriggered事件
                     */
                    pipeline.addLast(new IdleStateHandler(5, 8, 11, TimeUnit.SECONDS));
                    // 加入一个对空闲检测进一步处理的handler(自定义)
                    pipeline.addLast(new SampleHeartServerHandler());
                }
            });

            // 启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();

        } finally {
            masterGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
