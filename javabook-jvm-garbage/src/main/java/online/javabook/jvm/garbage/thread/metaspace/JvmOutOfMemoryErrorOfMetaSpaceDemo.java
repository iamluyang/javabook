package online.javabook.jvm.garbage.thread.metaspace;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * <p>
 * -XX:MaxMetaspaceSize=100M -XX:+PrintGCDetails
 * <p>
 * Error occurred during initialization of VM
 * OutOfMemoryError: Metaspace
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 */
public class JvmOutOfMemoryErrorOfMetaSpaceDemo {

    /**
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            String propertyName = "propertyName";
            long count = 1;
            while (true) {
                BeanGenerator beanGenerator = new BeanGenerator();
                beanGenerator.addProperty(propertyName + count, String.class);
                Object dynamicPropertyClass = beanGenerator.create();
                System.out.println("动态类型dynamicPropertyClass:" + dynamicPropertyClass.getClass().getName());

                count++;
            }
        } catch (Exception e) {
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            System.out.println("共加载过的类型数目:" + loadingBean.getTotalLoadedClassCount());
            System.out.println("当前有效的类型数目:" + loadingBean.getLoadedClassCount());
            System.out.println("已被卸载的类型数目:" + loadingBean.getUnloadedClassCount());

            e.printStackTrace();
        }
    }
}