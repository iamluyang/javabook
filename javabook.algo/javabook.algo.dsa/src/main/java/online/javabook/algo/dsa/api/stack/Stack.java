package online.javabook.algo.dsa.api.stack;

/**
 * Stack implementation in Java
 */
class Stack {
    private int arr[];
    private int top;
    private int capacity;

    // Creating a stack
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    /**
     * Add elements into stack
     * @param x
     */
    public void push(int x) {
        if (isFull()) {
            throw new StackOverflowError("stack is full.");
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    /**
     * Remove element from stack
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new StackOverflowError("stack is empty.");
        }
        return arr[top--];
    }

    /**
     * Utility function to return the size of the stack
     * @return
     */
    public int size() {
        return top + 1;
    }

    /**
     * Check if the stack is empty
     * @return
     */
    public Boolean isEmpty() {
        return top == -1;
    }

    /**
     * Check if the stack is full
     * @return
     */
    public Boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * print stack
     */
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("\nAfter popping out");

        stack.printStack();
    }
}