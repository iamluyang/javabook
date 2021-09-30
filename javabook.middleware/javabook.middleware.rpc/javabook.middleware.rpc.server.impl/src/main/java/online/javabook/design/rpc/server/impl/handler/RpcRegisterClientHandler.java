package online.javabook.design.rpc.server.impl.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcRegisterClientHandler extends IoHandlerAdapter {

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        session.closeOnFlush();
    }

    @Override
    public void messageReceived(IoSession session, Object message) {

    }
}
