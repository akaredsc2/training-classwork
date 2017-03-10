package org.vitaly.week06.lesson17.syncronousQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by vitaly on 10.03.17.
 */

class MyThread extends Thread {
    private SynchronousQueue queue;

    public MyThread(SynchronousQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
//            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        MyThread thread1 = new MyThread(synchronousQueue);

        thread1.start();
        synchronousQueue.put(10);
    }
}
