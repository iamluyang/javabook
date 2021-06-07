package online.javabook.design.nio.server.message.processor;

import online.javabook.design.nio.server.message.Message;
import online.javabook.design.nio.server.write.proxy.WriteProxy;

public interface IMessageProcessor {

    /**
     *
     * @param request
     * @param writeProxy
     */
    public void process(Message request, WriteProxy writeProxy);

}
