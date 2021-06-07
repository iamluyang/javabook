package online.javabook.design.nio.server.message.reader;

import online.javabook.design.nio.server.message.Message;
import online.javabook.design.nio.server.message.MessageBuffer;
import online.javabook.design.nio.server.session.Session;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public interface IMessageReader {

    /**
     *
     * @param readMessageBuffer
     */
    public void init(MessageBuffer readMessageBuffer);

    /**
     *
     * @param socket
     * @param byteBuffer
     * @throws IOException
     */
    public void read(Session socket, ByteBuffer byteBuffer) throws IOException;

    /**
     *
     * @return
     */
    public List<Message> getMessages();

}
