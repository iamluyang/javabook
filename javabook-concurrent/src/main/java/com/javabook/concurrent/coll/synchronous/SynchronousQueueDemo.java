package com.javabook.concurrent.coll.synchronous;

import java.util.concurrent.SynchronousQueue;

/**
 * 技术特性
 * 1- 数据结构：一种阻塞队列，其中每个插入操作必须等待另一个线程的对应移除操作 ，反之亦然。
 * 2- 容器边界：同步队列没有任何内部容量，甚至连一个队列的容量都没有。
 * 					  不能在同步队列上进行 peek，因为仅在试图要移除元素时，该元素才存在；
 *                    除非另一个线程试图移除某个元素，否则也不能（使用任何方法）插入元素；
 *                    也不能迭代队列，因为其中没有元素可用于迭代。
 *                    
 * 3- 阻塞性质：队列的头 是尝试添加到队列中的首个已排队插入线程的元素；
 *                    如果没有这样的已排队线程，则没有可用于移除的元素并且 poll() 将会返回 null。
 *                    对于其他 Collection 方法（例如 contains），SynchronousQueue 作为一个空 collection。
 *                    此队列不允许 null 元素。 
 *                    
 * 4- 使用场景：对于正在等待的生产者和使用者线程而言，此类支持可选的公平排序策略。
 * 					  默认情况下不保证这种排序。但是，使用公平设置为 true 所构造的队列可保证线程以 FIFO 的顺序进行访问。 
 *     
 *  构造函数
 *  
 * SynchronousQueue() 
 *          创建一个具有非公平访问策略的 SynchronousQueue。 
 *          
 * SynchronousQueue(boolean fair) 
 *          创建一个具有指定公平策略的 SynchronousQueue。 
 *  
 *  重要方法
 *
 *  算法与数据结构

 * 私有方法
 *     
 *    
 * @author LuYang
 *
 */
public class SynchronousQueueDemo {

	public static void main(String args[]){  
        
        final SynchronousQueue<String> queue = new SynchronousQueue<String>();  
          
        for (int i=0; i<10; i++){  
            new Thread(new Runnable() {  
                @Override  
                public void run() {  
                    try {  
                        synchronized (SynchronousQueueDemo.class) {  
                            String input = queue.take();  
                            String output = TestDo.doSome(input);  
                            System.out.println(Thread.currentThread().getName() + ":" + output);  
                        }  
                          
                    } catch (InterruptedException e) {  
                        // TODO Auto-generated catch block  
                        e.printStackTrace();  
                    }  
                }  
            }).start();  
        }  
          
          
        System.out.println("begin:");  
          
        for (int i=0; i<10; i++){  
            String input = i + "";  
            try {  
                queue.put(input);  
                  
                System.out.println(i + ":放置结束");  
                  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
          
    }  
}  
  
class TestDo{  
      
    public static String doSome(String input){  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
        String output = input + ":" + System.currentTimeMillis()/1000;  
        return output;  
    }  
      
}  
