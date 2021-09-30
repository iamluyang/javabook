package online.javabook.jvm.thread.aba;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * <ul>
 * <li>1.ABA并非一定是一个错误，而是一种多个线程在交替执行过程中可能发生的现象。
 * AtomicStampedReference提供了一种机制能够发现是否发生了ABA，从而决定是否要处理这种情况。
 *
 * <li>2.代码中通过Thread.sleep来切换线程的执行顺序，加大ABA的几率，否则该现象将会随机发生。
 * </ul>
 *
 * @author LuYang
 */
public final class CheckABAMain {

    private static Random random = new Random();

    /**
     * 把内容A放在一个原子的引用对象中：内容+标记
     */
    private static AtomicStampedReference<String> content = new AtomicStampedReference<String>("A", random.nextInt());

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        // 线程1
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                int oldStamp = CheckABAMain.content.getStamp();
                String oldContent = CheckABAMain.content.getReference();

                System.out.println("线程T1首先看到内容[" + oldContent + "]和操作标记[" + oldStamp + "]");
                try {
                    // T1实际上被强制sleep一会，好让T2这个时候有机可乘
                    System.out.println("T1现在有事情暂时的离开了一小会");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 线程T1对原子引用类型进行CAS操作
                boolean result = CheckABAMain.content.compareAndSet("A", "C", oldStamp, random.nextInt());

                if (!result) {
                    System.out.println("线程T1的CAS发现原子标记引用中的标记被篡改了，因此线程T1的CAS操作没有成功");
                }
            }
        });

        // 线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // T2先sleep一会，好让T1有机会先看到原子引用类型的内容
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // T2第一次修改了原子引用类型的内容和标记
                int oldStamp1 = content.getStamp();
                String oldContent = content.getReference();
                boolean firstOpt = content.compareAndSet(oldContent, "B", oldStamp1, random.nextInt());
                if (firstOpt) {
                    System.out.println("T2悄悄将原子引用类型的内容[A]改成[B]");
                }

                // T2第2次修改了原子引用类型的内容和标记
                int oldStamp2 = content.getStamp();
                boolean secondOpt = content.compareAndSet("B", "A", oldStamp2, random.nextInt());
                if (secondOpt) {
                    System.out.println("T2悄悄把原子引用类型的内容[B]改回[A]。" + "现在原子引用类型的内容好像没被修改过一样。");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
