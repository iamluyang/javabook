package online.javabook.jdk.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NioGroupChatServer {

    public static void main(String[] args) {
        // 创建服务器对象
        NioGroupChatServer nioGroupChatServer = new NioGroupChatServer();
        nioGroupChatServer.listen();
    }

    /**
     * selector
     */
    private Selector selector;

    /**
     * serverSocketChannel
     */
    private ServerSocketChannel serverSocketChannel;

    /**
     * port
     */
    private static final int PORT = 9999;

    public NioGroupChatServer() {

        try {
            // 创建服务器端选择器
            selector = Selector.open();

            // ServerSocketChannel
            serverSocketChannel = ServerSocketChannel.open();

            // 绑定服务器端的端口
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));

            // 设置服务器非阻塞模式
            serverSocketChannel.configureBlocking(false);

            // 将服务器端通道注册到selector
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 监听
    public void listen() {

        System.out.println("监听线程: " + Thread.currentThread().getName());
        try {
            // 循环处理
            while (true) {

                int count = selector.select();

                // 有事件触发
                if (count > 0) {

                    // 得到selectionKey的迭代集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        // 取出selectionkey
                        SelectionKey key = iterator.next();

                        // 监听到accept事件
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);

                            // 将该 socketChannel 注册到 selector
                            socketChannel.register(selector, SelectionKey.OP_READ);

                            // 上线提示
                            System.out.println(socketChannel.getRemoteAddress() + " 上线 ");

                        }

                        // 通道发送read事件，即通道是可读的状态
                        if (key.isReadable()) {
                            //处理读 (专门写方法..)
                            readData(key);
                        }

                        // 删除key，防止重复处理
                        iterator.remove();
                    }

                } else {
                    System.out.println("等待....");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //发生异常处理....
        }
    }

    //读取客户端消息
    private void readData(SelectionKey key) {

        // 取到关联的 channel
        SocketChannel socketChannel = null;

        try {
            // 得到socketChannel
            socketChannel = (SocketChannel) key.channel();

            // 分配字节缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = socketChannel.read(buffer);

            // 根据count的值做处理
            if (count > 0) {
                // 把缓存区的数据转成字符串
                String message = new String(buffer.array());

                // 输出该消息
                System.out.println("form 客户端: " + message);

                // 向其它的客户端转发消息(去掉自己), 专门写一个方法来处理
                sendInfoToOtherClients(socketChannel, message);
            }
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + " 离线了...");

                // 取消注册
                key.cancel();

                // 关闭通道
                socketChannel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    // 转发消息给其它客户(通道)
    private void sendInfoToOtherClients(SocketChannel selfSocketChannel, String msg) throws IOException {

        System.out.println("服务器转发消息中...");
        System.out.println("服务器转发数据给客户端线程: " + Thread.currentThread().getName());

        // 遍历所有注册到selector上的SocketChannel, 并排除selfSocketChannel
        for (SelectionKey selectionKey : selector.keys()) {

            // 通过key取出对应的 SocketChannel
            Channel targetChannel = selectionKey.channel();

            // 排除自己的SocketChannel和服务器Channel
            if (targetChannel instanceof SocketChannel && targetChannel != selfSocketChannel) {

                // 转型
                SocketChannel destSocketChannel = (SocketChannel) targetChannel;

                // 将msg存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

                // 将buffer的数据写入通道
                destSocketChannel.write(buffer);
            }
        }
    }
}

