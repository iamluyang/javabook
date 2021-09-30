package online.javabook.jboss.netty.sample01.quickstart;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws Exception {

        // 创建BossGroup 和 WorkerGroup
        // 1. 创建两个线程组bossGroup和workerGroup，两个都是无限循环
        // 2. bossGroup只是处理连接请求 , 真正的和客户端业务处理，会交给 workerGroup完成
        // 3. bossGroup 和 workerGroup 含有的子线程(NioEventLoop)的个数默认实际 cpu核数 * 2
        EventLoopGroup masterGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建服务器端的启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 1.设置两个线程组
            // 2.使用链式编程来进行设置
            serverBootstrap.group(masterGroup, workerGroup)
                    // 使用NioSocketChannel 作为服务器的通道实现
                    .channel(NioServerSocketChannel.class)
                    // 设置线程队列得到连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 设置保持活动连接状态选项
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // handler对应bossGroup
                    //.handler(null)
                    // childHandler对应workerGroup, 给workerGroup的EventLoop对应的管道设置处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道初始化对象(匿名对象)
                        // 给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("客户socketchannel hashcode=" + socketChannel.hashCode());
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    }); //

            // 绑定一个端口并且同步, 生成了一个ChannelFuture对象启动服务器(并绑定端口)
            System.out.println("服务器启动中......");
            ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();

            // 给channelFuture注册监听器，监控我们关心的事件
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("服务器启动成功:监听端口6668");
                    } else {
                        System.out.println("服务器启动失败:监听端口6668");
                    }
                }
            });

            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            masterGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
