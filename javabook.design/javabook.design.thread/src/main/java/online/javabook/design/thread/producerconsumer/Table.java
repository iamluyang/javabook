package online.javabook.design.thread.producerconsumer;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Table {
	
    /**
     * buffer
     */
    private final String[] buffer;
    
    /**
     * tail
     */
    private int tail; 
    
    /**
     * head
     */
    private int head;  
    
    /**
     * count
     */
    private int count;
    
    /**
     * @param count
     */
    public Table(int count) {
        this.buffer = new String[count];
        this.head   = 0;
        this.tail   = 0;
        this.count  = 0;
    }

    /**
     * @param cake
     * @throws InterruptedException
     */
    public synchronized void put(String cake) throws InterruptedException {
    	
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    /**
     * @return
     * @throws InterruptedException
     */
    public synchronized String take() throws InterruptedException {
    	
        while (count <= 0) {
            wait();
        }
        
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
