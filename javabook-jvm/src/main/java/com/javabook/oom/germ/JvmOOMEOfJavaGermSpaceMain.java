package com.javabook.oom.germ;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

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
            //准备url
            URL url = new File("D:/git/apache/javabook/javabook-oom/src/main/java/com/javabook/oom/germ").toURI().toURL();
            URL[] urls = {url};

            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<>();

            while (true) {
                //加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("com.javabook.oom.germ.LoaderClass");

                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                System.out.println("active: " + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}