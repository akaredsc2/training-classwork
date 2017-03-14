package org.vitaly.week07.lesson18.reentrantLock;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vitaly on 13.03.17.
 */

class Producer extends Thread {
    Queue<Integer> queue;
    Lock lock;
    Condition condition;

    public Producer(Queue<Integer> queue, Lock lock, Condition condition) {
        this.queue = queue;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        while (queue.size() > 5) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        condition.signal();
        lock.unlock();
    }
}

class Consumer extends Thread {
    Queue<Integer> queue;
    Lock lock;
    Condition condition;

    public Consumer(Queue<Integer> queue, Lock lock, Condition condition) {
        this.queue = queue;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        while (queue.size() == 5) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        condition.signal();
        lock.unlock();
    }
}

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue, lock, condition);
        Consumer consumer1 = new Consumer(queue, lock, condition);
        Consumer consumer2 = new Consumer(queue, lock, condition);

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
