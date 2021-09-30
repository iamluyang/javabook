package online.javabook.algo.dsa.api.queue;

/**
 * Queue implementation in Java
 */
public class DefaultQueue {
    int items[];
    int size;
    int front, rear;

    public DefaultQueue(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        this.items = new int[size];
    }

    /**
     * Check if the queue is full
     *
     * @return
     */
    boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }

    /**
     * Check if the queue is empty
     *
     * @return
     */
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    /**
     * Add elements into queue
     *
     * @param element
     */
    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }

            rear++;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    /**
     * Remove element from queue
     *
     * @return
     */
    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Deleted -> " + element);
            return (element);
        }
    }

    /**
     * Function to display elements of Queue
     */
    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++) {
                System.out.print(items[i] + "  ");
            }
            System.out.println("\nRear index-> " + rear);
        }
    }

    public static void main(String[] args) {
        DefaultQueue q = new DefaultQueue(5);

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 6th element can't be added to because the queue is full
        q.enQueue(6);

        q.display();

        // deQueue removes element entered first i.e. 1
        q.deQueue();

        // Now we have just 4 elements
        q.display();
    }
}
