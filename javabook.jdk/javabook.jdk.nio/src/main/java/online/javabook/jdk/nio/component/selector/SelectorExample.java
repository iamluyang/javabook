package online.javabook.jdk.nio.component.selector;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorExample {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel channel = null;

        // 创建选择器
        Selector selector = Selector.open();

        // Channel必须在非阻塞模式下使用Selector。
        // 这意味着不能将FileChannel注册到Selector，因为 FileChannel不能切换到非阻塞模式。不过，套接字通道可以正常工作。
        channel.configureBlocking(false);

        // 将通道注册到选择器中
        // register()方法的第二个参数,这是一个“兴趣集”，意思是可以通过选择器监听通道的一组事件，您可以监听四种不同的事件：
        // Connect/Accept/Read/Write
        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);

        while(true) {
            // 检测是否有一个或多个通道已经准备就绪
            int readyChannels = selector.selectNow();
            if(readyChannels == 0) continue;

            // 通过选择器返回的就绪选择Key获取就绪的通道

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while(keyIterator.hasNext()) {

                SelectionKey readySelectionKey = keyIterator.next();
                if(readySelectionKey.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.

                } else if (readySelectionKey.isConnectable()) {
                    // a connection was established with a remote server.

                } else if (readySelectionKey.isReadable()) {
                    // a channel is ready for reading

                } else if (readySelectionKey.isWritable()) {
                    // a channel is ready for writing
                }

                // 手动删除掉已经触发和处理掉的通道事件，但不会删除实际注册到选择器中的Channel
                // 当下次通道变为“就绪”时，Selector将再次将其添加到选定的键集中（selectedKeys）
                keyIterator.remove();
            }
        }
    }

    // -------------------------------------------------------------------
    // selectedKeys - 返回被选择器中所有注册的Channel对应的SelectionKey
    // -------------------------------------------------------------------

    private Set<SelectionKey> keys(Selector selector) {
        return selector.keys();
    }

    // -------------------------------------------------------------------
    // selectedKeys - 返回被选择器中被触发事件Channel对应的SelectionKey
    // -------------------------------------------------------------------

    private Set<SelectionKey> selectedKeys(Selector selector) {
        return selector.selectedKeys();
    }

    // -------------------------------------------------------------------
    // interestOps Set 是通道向选择器注册时感兴趣的事件集合
    // -------------------------------------------------------------------
    private boolean isInterestedInAccept(SelectionKey selectionKey) {
        int interests = selectionKey.interestOps();
        boolean isInterestedInAccept = SelectionKey.OP_ACCEPT == (interests & SelectionKey.OP_ACCEPT);
        return isInterestedInAccept;
    }

    private boolean isInterestedInConnect(SelectionKey selectionKey) {
        int interests = selectionKey.interestOps();
        boolean isInterestedInConnect = SelectionKey.OP_CONNECT == (interests & SelectionKey.OP_CONNECT);
        return isInterestedInConnect;
    }

    private boolean isInterestedInRead(SelectionKey selectionKey) {
        int interests = selectionKey.interestOps();
        boolean isInterestedInRead = SelectionKey.OP_READ == (interests & SelectionKey.OP_READ);
        return isInterestedInRead;
    }

    private boolean isInterestedInWrite(SelectionKey selectionKey) {
        int interests = selectionKey.interestOps();
        boolean isInterestedInWrite = SelectionKey.OP_WRITE == (interests & SelectionKey.OP_WRITE);
        return isInterestedInWrite;
    }

    // -------------------------------------------------------------------
    // readyOps Set - 就绪集是通道准备好的操作集
    // -------------------------------------------------------------------

    private boolean isAcceptable(SelectionKey selectionKey) {
        return selectionKey.isAcceptable();
    }

    private boolean isConnectable(SelectionKey selectionKey) {
        return selectionKey.isConnectable();
    }

    private boolean isReadable(SelectionKey selectionKey) {
        return selectionKey.isReadable();
    }

    private boolean isWritable(SelectionKey selectionKey) {
        return selectionKey.isWritable();
    }

    // -------------------------------------------------------------------
    // Channel + Selector: 可以通过selectionKey访问到它对应的Channel和Selector
    // -------------------------------------------------------------------

    private Channel getChannel(SelectionKey selectionKey) {
        Channel channel = selectionKey.channel();
        return channel;
    }

    private Selector  getSelector(SelectionKey selectionKey) {
        Selector selector = selectionKey.selector();
        return selector;
    }

    // -------------------------------------------------------------------
    // Attaching Objects: 可以将一个对象附加绑定到选择器键上
    // -------------------------------------------------------------------

    private void attachObject(SelectionKey selectionKey, Object object) {
        selectionKey.attach(object);
    }

    private Object getAttachObject(SelectionKey selectionKey) {
        return selectionKey.attachment();
    }

    // -------------------------------------------------------------------
    // wakeUp() - 当选择器被select()阻塞，可以通过其他线程唤醒这个阻塞操作
    // -------------------------------------------------------------------

    private void wakeupSelector(Selector selector) throws IOException {
        selector.wakeup();
    }

    // -------------------------------------------------------------------
    // close() - 选择器时可以调用其close()方法。这将关闭选择器，
    // 并使在此选择器中注册的所有SelectionKey实例无效。但通道本身未关闭。
    // -------------------------------------------------------------------

    private void closeSelector(Selector selector) throws IOException {
        selector.close();
    }

}
