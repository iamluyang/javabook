package online.javabook.jdk.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NioGroupChatClient {

    public static void main(String[] args) throws Exception {

        // 启动客户端
        NioGroupChatClient chatClient = new NioGroupChatClient();

        // 启动一个线程, 每个3秒，读取从服务器发送数据
        new Thread(() -> {
            while (true) {
                chatClient.readMessage();
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 发送数据给服务器端
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            chatClient.sendMessage(s);
        }
    }

    // 服务器的ip
    private final String HOST = "127.0.0.1";

    //服务器端口
    private final int PORT = 9999;

    private Selector selector;

    private SocketChannel socketChannel;

    private String username;

    // 构造器, 完成初始化工作
    public NioGroupChatClient() throws IOException {

        // 创建客户端选择器
        selector = Selector.open();

        // 连接服务器
        socketChannel = socketChannel.open(new InetSocketAddress("127.0.0.1", PORT));

        // 设置非阻塞
        socketChannel.configureBlocking(false);

        //将channel 注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);

        //得到username
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username + " is ok...");
    }

    // 向服务器发送消息
    public void sendMessage(String message) {
        message = username + " 说：" + message;
        try {
            socketChannel.write(ByteBuffer.wrap(message.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取从服务器端回复的消息
    public void readMessage() {

        try {
            int readChannels = selector.select();
            if (readChannels > 0) {//有可以用的通道

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        // 得到相关的通道
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        // 分配一个Buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);

                        // 读取通道中的数据
                        socketChannel.read(buffer);

                        // 把读到的缓冲区的数据转成字符串
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    }
                }

                // 删除当前的selectionKey, 防止重复操作
                iterator.remove();
            } else {
                // System.out.println("没有可以用的通道...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
