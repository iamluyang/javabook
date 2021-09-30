package online.javabook.jdk.nio.component.selector;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Java NIO的非阻塞模式，使一个线程从某通道发送请求或者读取数据，
 * 但是它仅能得到目前可用的数据，如果目前没有数据可用时，就什么都不会获取，
 * 而不是保持线程阻塞，所以直至数据变的可以读取之前，该线程可以继续做其他的事情。
 * 非阻塞写也是如此，一个线程请求写入一些数据到某通道，但不需要等待它完全写入，
 * 这个线程同时可以去做别的事情
 *
 * 该示例依然不能高效的解决高并发的场景，目前只有一个主线程来完成所有功能
 * 可以使用单Reactor多线程模式或Reactor主从多线程模式来解决
 */
public class NioServer {

    public static void main(String[] args) throws Exception {

        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 创建一个Selector对象
        Selector selector = Selector.open();

        // 绑定端口在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));

        // 设置Channel为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 把serverSocketChannel注册到selector，关注的事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 1
        System.out.println("注册后的selectorkeys数量=" + selector.keys().size());

        //循环等待客户端连接
        while (true) {

            // 等待1秒，如果没有事件发生则返回
            // selector.select();        //无限阻塞，直到接收到一个网络事件
            // selector.selectNow();     //立即返回，不管有没有网络事件到来
            // selector.select(timeout); //超时阻塞，直到接收到一个网络事件
            // selector.wakeup()         //唤醒阻塞中的selector
            if (selector.select(1000) == 0) {
                //System.out.println("服务器等待了1秒，无客户端连接");
                continue;
            }

            // 如果返回的>0, 就获取到相关的 selectionKey集合
            // 1.如果返回的>0， 表示已经获取到关注的事件
            // 2.selector.selectedKeys() 返回关注事件的集合
            // 通过 selectionKeys 反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys数量 = " + selectionKeys.size());

            // 遍历 Set<SelectionKey>, 使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                // 获取到SelectionKey
                SelectionKey key = keyIterator.next();

                // 根据key 对应的通道发生的事件做相应处理
                if (key.isAcceptable()) { //如果是 OP_ACCEPT, 有新的客户端连接

                    // 为该该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成了一个对应的socketChannel " + socketChannel.hashCode());

                    // 将SocketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);

                    // 将socketChannel注册到selector, 关注事件为 OP_READ， 同时给socketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                    // 2,3,4......
                    System.out.println("客户端连接后，注册的selectionkey数量=" + selector.keys().size());
                }

                if (key.isReadable()) {  //发生 OP_READ
                    // 通过key反向获取到对应channel
                    SocketChannel channel = (SocketChannel) key.channel();

                    // 获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("buffer:"+buffer);
                    System.out.println("客户端请求的消息:" + new String(buffer.array()));
                    buffer.clear();
                }

                // 手动从集合中移除当前的selectionKey, 防止重复操作
                keyIterator.remove();
            }
        }
    }
}
