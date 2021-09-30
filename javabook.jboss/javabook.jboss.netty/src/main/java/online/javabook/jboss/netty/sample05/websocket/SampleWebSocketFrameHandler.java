package online.javabook.jboss.netty.sample05.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

// TextWebSocketFrame表示一个文本帧处理器
public class SampleWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 当web客户端连接后， 触发方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // id 表示唯一的值: LongText 是唯一的, ShortText 不是唯一.
        System.out.println("handlerAdded 被调用:" + ctx.channel().id().asLongText());
        System.out.println("handlerAdded 被调用:" + ctx.channel().id().asShortText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved 被调用" + ctx.channel().id().asLongText());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("服务器收到消息 " + msg.text());
        // 回复消息
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间:" + LocalDateTime.now() + " " + msg.text()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生 " + cause.getMessage());
        ctx.close(); //关闭连接
    }
}
