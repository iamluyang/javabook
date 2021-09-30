package online.javabook.jboss.netty.dubborpc.provider;

import online.javabook.jboss.netty.dubborpc.netty.NettyServer;

// ServerBootstrap会启动一个服务提供者，就是NettyServer
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
