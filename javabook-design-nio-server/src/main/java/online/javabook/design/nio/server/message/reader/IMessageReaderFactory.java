package online.javabook.design.nio.server.message.reader;

public interface IMessageReaderFactory {

    public IMessageReader createMessageReader();

}