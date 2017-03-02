package org.vitaly.week05.lesson14.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vitaly on 01.03.17.
 */

class Producer extends Thread {
    private Queue<Object> queue;
    private String name;

    public Producer(Queue<Object> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {

                //wait until there are empty spots in queue
                while (queue.size() >= 5) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //we have at least one empty spot in queue
                queue.add(new Object());

                System.out.println("Thread " + this.name + " put element in queue");

                //put last
//                queue.notify();
                queue.notifyAll();
            }
            /*
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            Thread.yield();
        }
    }
}

class Consumer extends Thread {
    private Queue<Object> queue;
    private String name;

    public Consumer(Queue<Object> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();

                System.out.println("Thread " + this.name + " polled element in queue");

//                queue.notify();
                queue.notifyAll();
            }
            /*
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            Thread.yield();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Object> queue = new LinkedList<>();
        Producer producer1 = new Producer(queue, "producer1");
        Producer producer2 = new Producer(queue, "producer2");

        Consumer consumer1 = new Consumer(queue, "consumer1");
        Consumer consumer2 = new Consumer(queue, "consumer2");
        Consumer consumer3 = new Consumer(queue, "consumer3");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        //just for Main thread to hang around
        producer1.join();
    }
}
