package online.javabook.jvm.thread.jcu.lock.readwritelock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();

        // ReaderThread
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();
        new ReaderThread(resource).start();

        // WriterThread
        new WriterThread(resource, 'A').start();
        new WriterThread(resource, 'B').start();
        new WriterThread(resource, 'C').start();
    }
}
