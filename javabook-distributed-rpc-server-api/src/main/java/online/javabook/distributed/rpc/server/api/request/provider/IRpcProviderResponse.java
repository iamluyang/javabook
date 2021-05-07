package online.javabook.distributed.rpc.server.api.request.provider;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcProviderResponse {

    /**
     * @return
     */
    public Object getResult();

    /**
     * @return
     */
    public void setResult(Object result);

    // ----------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public Throwable getThrowable();

    /**
     * @return
     */
    public void setThrowable(Throwable throwable);

}
