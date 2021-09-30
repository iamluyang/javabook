package com.nanosai.threadops.ringbuffer;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class RingBlockingQueue implements BlockingQueue<Runnable> {

    private AtomicInteger head = new AtomicInteger(0);

    private AtomicInteger tail = new AtomicInteger(0);

    private AtomicReferenceArray<Runnable> items;

    private int size;

    public RingBlockingQueue(int size) {
        this.size = size;
        this.items = new AtomicReferenceArray<>(size);
    }

    @Override
    public boolean add(Runnable runnable) {
        while (items.compareAndSet(tail.get(), null, runnable)) {
            if(tail.get() + 1 == size) {
                tail.set(0);
            }else{
                tail.incrementAndGet();
            }
        }
        return true;
    }

    @Override
    public boolean offer(Runnable runnable) {
        return add(runnable);
    }

    @Override
    public void put(Runnable runnable) throws InterruptedException {
        add(runnable);
    }

    @Override
    public Runnable remove() {
        return null;
    }

    @Override
    public Runnable poll() {
        try {
            return this.poll(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Runnable element() {
        return null;
    }

    @Override
    public Runnable peek() {
        return items.get(head.get());
    }

    @Override
    public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Runnable take() throws InterruptedException {
        return poll();
    }

    @Override
    public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
        Runnable item = items.get(head.get());
        while (!items.compareAndSet(head.get(), item, null)) {
            item = items.get(head.get());
        }
        if(head.get() + 1 == size) {
            head.set(0);
        } else {
            head.incrementAndGet();
        }
        return item;
    }

    @Override
    public int remainingCapacity() {
        return size - tail.get() - head.get();
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Runnable> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.items = new AtomicReferenceArray<Runnable>(size);
    }

    @Override
    public int size() {
        return items.length();
    }

    @Override
    public boolean isEmpty() {
        return items.length() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Runnable> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int drainTo(Collection<? super Runnable> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super Runnable> c, int maxElements) {
        return 0;
    }
}
