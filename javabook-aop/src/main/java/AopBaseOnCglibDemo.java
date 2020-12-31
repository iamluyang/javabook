import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class AopBaseOnCglibDemo {
    public static void main(String[] args) {
                /*HelloWorldService helloWorldService = CreateLogProxy(HelloWorldService.class);
                classLoaders.add(helloWorldService);
                helloWorldService.sayHello("abc");*/

    }

    /**
     * 加载类型并缓存类加载器实例
     */
    private static <T> T CreateLogProxy(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);

        enhancer.setCallback((MethodInterceptor) (obj, method, objects, proxy) -> {
            System.out.println("Log begin.................");
            Object result = proxy.invokeSuper(obj, objects);
            System.out.println("Log finish.................");
            return result;
        });
        return (T)enhancer.create();
    }
}
