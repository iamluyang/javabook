package online.javabook.distributed.rpc.server.api.listener;

import java.util.EventListener;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcServiceListener extends EventListener {

    /**
     * Receives notification that a service has had a lifecycle change.
     *
     * @param event The {@code ServiceEvent} object.
     */
    public void serviceChanged(RpcServiceEvent event);
}

