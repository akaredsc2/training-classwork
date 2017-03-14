package org.vitaly.week07.lesson18.readWriteLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by vitaly on 13.03.17.
 */

class Writer extends Thread {
    Queue<Integer> queue;
    Lock lock;

    public Writer(Queue<Integer> queue, Lock writeLock) {
        this.queue = queue;
        this.lock = writeLock;
    }

    @Override
    public void run() {
        lock.lock();
        queue.offer(10);
        lock.unlock();
    }
}

class Reader extends Thread {
    Queue<Integer> queue;
    Lock lock;

    public Reader(Queue<Integer> queue, Lock readLock) {
        this.queue = queue;
        this.lock = readLock;
    }

    @Override
    public void run() {
        lock.lock();
        queue.peek();
        lock.unlock();
    }
}

public class Main {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Queue<Integer> queue = new LinkedList<>();

        Writer writer = new Writer(queue, readWriteLock.writeLock());
        Reader reader1 = new Reader(queue, readWriteLock.readLock());
        Reader reader2 = new Reader(queue, readWriteLock.readLock());

        writer.start();
        reader1.start();
        reader2.start();
    }
}
