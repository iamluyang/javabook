package online.javabook.jboss.netty.sample01.quickstart;

import io.netty.util.NettyRuntime;

public class DebugNettyRuntime {
    public static void main(String[] args) {
        System.out.println(NettyRuntime.availableProcessors());
    }
}
