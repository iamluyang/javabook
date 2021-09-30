package online.javabook.jboss.netty.dubborpc.customer;

import online.javabook.jboss.netty.dubborpc.netty.NettyClient;
import online.javabook.jboss.netty.dubborpc.service.api.HelloService;

public class ClientCustomerBootstrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws Exception {

        NettyClient customer = new NettyClient();

        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);
        for (;;) {
            Thread.sleep(2 * 1000);
            String res = service.hello("你好 dubbo~");
            System.out.println("调用的结果 res= " + res);
        }
    }
}
