package online.javabook.jvm.thread.samethread;

import net.sf.cglib.beans.BeanGenerator;

import java.io.IOException;
import java.util.UUID;

public class SlowTask implements Runnable {

    private static UUID uuid = UUID.randomUUID();

    @Override
    public void run() {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        Object dynamicPropertyClass = beanGenerator.create();
    }

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        beanGenerator.addProperty(UUID.randomUUID().toString(), String.class);
        Object dynamicPropertyClass = beanGenerator.create();

        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
    }
}
