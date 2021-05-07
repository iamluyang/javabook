package online.javabook.distributed.rpc.server.api.reference;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcServiceReference {

    /**
     * @return
     */
    public <S> S getService();

    /**
     *
     */
    public void close();
}
