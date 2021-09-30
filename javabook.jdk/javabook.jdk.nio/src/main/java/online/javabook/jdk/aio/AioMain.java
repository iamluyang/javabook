package online.javabook.jdk.aio;

/**
 * JDK 7引入了Asynchronous I/O，即AIO。在进行I/O编程中，常用到两种模式：Reactor 和 Proactor。
 * Java的NIO就是Reactor，当有事件触发时，服务器端得到通知，进行相应的处理
 *
 * AIO即NIO2.0，叫做异步不阻塞的IO。AIO引入异步通道的概念，采用了Proactor 模式，简化了程序编写，
 * 有效的请求才启动线程，它的特点是先由操作系统完成后才通知服务端程序启动线程去处理，一般适用于连接数
 * 较多且连接时间较长的应用
 */
public class AioMain {
}
