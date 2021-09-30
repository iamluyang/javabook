package online.javabook.jboss.netty.sample01.quickstart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter(规范)
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // 读取数据实际(这里我们可以读取客户端发送的消息)
    // 1. ChannelHandlerContext ctx:上下文对象, 含有 管道pipeline , 通道channel, 地址
    // 2. Object msg: 就是客户端发送的数据，默认为Object类型
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        /**
         // 耗时任务, 解决方案1: 用户程序自定义的普通任务 -> 该任务是提交到channel对应的NIOEventLoop的taskQueue中
         ctx.channel().eventLoop().execute(new Runnable() {
        @Override public void run() {
        try {
        Thread.sleep(5 * 1000);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端1", CharsetUtil.UTF_8));
        System.out.println("channel code=" + ctx.channel().hashCode());
        } catch (Exception ex) {
        System.out.println("发生异常" + ex.getMessage());
        }
        }
        });

         // 耗时任务, 解决方案2: 用户程序自定义定时任务 -> 该任务是提交到channel对应的NIOEventLoop的scheduleTaskQueue中
         ctx.channel().eventLoop().schedule(new Runnable() {
        @Override public void run() {

        try {
        Thread.sleep(5 * 1000);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵4", CharsetUtil.UTF_8));
        System.out.println("channel code=" + ctx.channel().hashCode());
        } catch (Exception ex) {
        System.out.println("发生异常" + ex.getMessage());
        }
        }
        }, 5, TimeUnit.SECONDS);
         */

        // 将 msg 转成一个 ByteBuf
        // ByteBuf是Netty提供的，不是NIO的ByteBuffer
        ByteBuf byteBuf = (ByteBuf) msg;
        Channel channel = ctx.channel();
        System.out.println("服务器读取线程 " + Thread.currentThread().getName() + " channel =" + ctx.channel());
        System.out.println("收到客户端消息:" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("收到客户端地址:" + ctx.channel().remoteAddress());
    }

    // 数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // writeAndFlush 是 write + flush
        // 将数据写入到缓存区并刷出
        // 对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端", CharsetUtil.UTF_8));
    }

    // 处理异常, 一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught:" + cause);
        ctx.close();
    }
}
