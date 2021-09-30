package online.javabook.jboss.netty;

/**
 * 1.NIO编程复杂：要熟悉Selector、ServerSocketChannel、SocketChannel、ByteBuffer等等
 * 2.NIO编程要求：要熟悉Java多线程编程，网络编程，设计模式，NIO编程涉及到 Reactor模式
 * 3.网络编程难度：例如客户端面临断连重连、网络闪断、半包读写、失败缓存、网络拥塞和异常流的处理等等。
 * 4.JDK NIO的Bug：EpollBug会导致Selector空轮询，最终导致CPU 100%。直到 JDK1.7版本该问题仍旧存在，没有被根本解决
 */
public class Main {
}
