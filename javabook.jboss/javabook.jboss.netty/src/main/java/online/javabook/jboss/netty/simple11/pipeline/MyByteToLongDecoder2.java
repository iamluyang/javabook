package online.javabook.jboss.netty.simple11.pipeline;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * ReplayingDecoder扩展了ByteToMessageDecoder类，使用这个类不必调用readableBytes()方法。
 * 泛型参数S指定了用户状态管理的类型，其中Void代表不需要状态管理
 *
 * ReplayingDecoder使用方便，但它也有一些局限性：
 * 1.并不是所有的 ByteBuf 操作都被支持，如果调用了一个不被支持的方法，将会抛出一个 UnsupportedOperationException
 * 2.ReplayingDecoder在某些情况下可能稍慢于ByteToMessageDecoder，例如网络缓慢并且消息格式复杂时，消息会被拆成了多个碎片速度变慢
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("MyByteToLongDecoder2 被调用");
        // 在 ReplayingDecoder 不需要判断数据是否足够读取，内部会进行处理判断
        out.add(in.readLong());
    }
}
