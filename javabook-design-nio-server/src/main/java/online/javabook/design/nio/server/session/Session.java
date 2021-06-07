package online.javabook.design.nio.server.session;

import online.javabook.design.nio.server.message.MessageWriter;
import online.javabook.design.nio.server.message.reader.IMessageReader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Session {

    public long socketId;

    public SocketChannel socketChannel = null;

    public IMessageReader messageReader = null;

    public MessageWriter messageWriter = null;

    public boolean endOfStreamReached = false;

    public Session() {

    }

    /**
     *
     * @param socketChannel
     */
    public Session(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    /**
     *
     * @param byteBuffer
     * @return
     * @throws IOException
     */
    public int read(ByteBuffer byteBuffer) throws IOException {
        int bytesRead = this.socketChannel.read(byteBuffer);
        int totalBytesRead = bytesRead;

        while (bytesRead > 0) {
            bytesRead = this.socketChannel.read(byteBuffer);
            totalBytesRead += bytesRead;
        }

        if (bytesRead == -1) {
            this.endOfStreamReached = true;
        }

        return totalBytesRead;
    }

    /**
     *
     * @param byteBuffer
     * @return
     * @throws IOException
     */
    public int write(ByteBuffer byteBuffer) throws IOException {
        int bytesWritten = this.socketChannel.write(byteBuffer);
        int totalBytesWritten = bytesWritten;

        while (bytesWritten > 0 && byteBuffer.hasRemaining()) {
            bytesWritten = this.socketChannel.write(byteBuffer);
            totalBytesWritten += bytesWritten;
        }

        return totalBytesWritten;
    }
}
