package online.javabook.design.nio.server.write.proxy;

import online.javabook.design.nio.server.message.Message;
import online.javabook.design.nio.server.message.MessageBuffer;

import java.util.Queue;

public class WriteProxy {

    private MessageBuffer messageBuffer;

    private Queue writeQueue;

    public WriteProxy(MessageBuffer messageBuffer, Queue writeQueue) {
        this.messageBuffer = messageBuffer;
        this.writeQueue = writeQueue;
    }

    public Message getMessage() {
        return this.messageBuffer.getMessage();
    }

    public boolean enqueue(Message message) {
        return this.writeQueue.offer(message);
    }

}
