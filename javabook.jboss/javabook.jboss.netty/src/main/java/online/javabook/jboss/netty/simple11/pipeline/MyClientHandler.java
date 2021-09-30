package online.javabook.jboss.netty.simple11.pipeline;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyClientHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("服务器的ip=" + ctx.channel().remoteAddress());
        System.out.println("收到服务器消息=" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler 发送数据");

        // 发送一个long
        ctx.writeAndFlush(123456L);

        // 分析
        // 1. "abcdabcdabcdabcd"是16个字节
        // 2. 该处理器的前一个handler是MyLongToByteEncoder
        // 3. MyLongToByteEncoder父类MessageToByteEncoder
        // 4. 编写Encoder是要注意传入的数据类型和处理的数据类型一致
        /*
        // 发送一个string
        // ctx.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcdabcd",CharsetUtil.UTF_8));
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            ByteBuf buf = null;
            try {
                if (acceptOutboundMessage(msg)) {
                    @SuppressWarnings("unchecked")
                    I cast = (I) msg;
                    buf = allocateBuffer(ctx, cast, preferDirect);
                    try {
                        encode(ctx, cast, buf);
                    } finally {
                        ReferenceCountUtil.release(cast);
                    }

                    if (buf.isReadable()) {
                        ctx.write(buf, promise);
                    } else {
                        buf.release();
                        ctx.write(Unpooled.EMPTY_BUFFER, promise);
                    }
                    buf = null;
                } else {
                    ctx.write(msg, promise);
                }
            } catch (EncoderException e) {
                throw e;
            } catch (Throwable e) {
                throw new EncoderException(e);
            } finally {
                if (buf != null) {
                    buf.release();
                }
            }
        }
        */
    }
}
