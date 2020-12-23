package com.javabook.oom.germ;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 * <p>
 * -XX:PermSize=4M -XX:MaxPermSize=4M
 * <p>
 * java.lang.OutOfMemoryError: PermGen space
 * <p>
 * or
 * <p>
 * -XX:MaxMetaspaceSize=1M
 * <p>
 * Error occurred during initialization of VM
 * OutOfMemoryError: Metaspace
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 */
public class JvmOOMEOfJavaGermSpaceMain {

    /**
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<Object> classLoaders = new ArrayList<>();

            while (true) {
                /*HelloWorldService helloWorldService = CreateLogProxy(HelloWorldService.class);
                classLoaders.add(helloWorldService);
                helloWorldService.sayHello("abc");*/

                BeanGenerator beanGenerator = new BeanGenerator();
                beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
                Object myBean = beanGenerator.create();

                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                System.out.println("total: "    + loadingBean.getTotalLoadedClassCount());
                System.out.println("active: "   + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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