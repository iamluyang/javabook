package online.javabook.jboss.netty.simple08.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class SimpleCodecNettyClient {
    public static void main(String[] args) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            // 在pipeline中加入ProtoBufEncoder
                            pipeline.addLast("encoder", new ProtobufEncoder());
                            // 添加自己的处理器
                            pipeline.addLast(new SimpleCodecNettyClientHandler());
                        }
                    });

            // 启动客户端去连接服务器端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
            System.out.println("客户端启动成功");

            //给关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {

            group.shutdownGracefully();

        }
    }
}
