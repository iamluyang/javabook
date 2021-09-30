package online.javabook.jboss.netty.sample02.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * 1. SimpleChannelInboundHandler 是 ChannelInboundHandlerAdapter
 * 2. HttpObject 客户端和服务器端相互通讯的数据被封装成 HttpObject
 */
public class SampleHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    //channelRead0 读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        System.out.println("this.hashCode():" + this.hashCode());

        System.out.println("context --------------------------------------");
        System.out.println("ctx.getClass()=" + ctx.getClass());

        System.out.println("channel --------------------------------------");
        System.out.println("ctx.channel()=" + ctx.channel());
        System.out.println("ctx.channel().remoteAddress()" + ctx.channel().remoteAddress());

        System.out.println("handler --------------------------------------");
        System.out.println("ctx.handler()=" + ctx.handler());

        System.out.println("pipeline--------------------------------------");
        System.out.println("ctx.pipeline()=" + ctx.pipeline());
        System.out.println("ctx.pipeline().channel()=" + ctx.pipeline().channel());
        System.out.println("ctx.pipeline().hashCode():" + ctx.pipeline().hashCode());

        System.out.println("message --------------------------------------");
        System.out.println("msg.getClass()" + msg.getClass());

        if (msg instanceof HttpRequest) {

            HttpRequest httpRequest = (HttpRequest) msg;

            // http body
            ByteBuf content = Unpooled.copiedBuffer("Hello, 我是Netty Http服务器", CharsetUtil.UTF_8);

            // http response
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // write
            ctx.writeAndFlush(response);
        }
    }
}
