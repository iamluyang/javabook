package online.javabook.design.nio.server.http;

import online.javabook.design.nio.server.message.reader.IMessageReader;
import online.javabook.design.nio.server.message.reader.IMessageReaderFactory;

public class HttpMessageReaderFactory implements IMessageReaderFactory {

    public HttpMessageReaderFactory() {
    }

    @Override
    public IMessageReader createMessageReader() {
        return new HttpMessageReader();
    }
}