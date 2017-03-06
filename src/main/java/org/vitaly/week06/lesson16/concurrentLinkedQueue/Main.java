package org.vitaly.week06.lesson16.concurrentLinkedQueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by vitaly on 06.03.17.
 */

class MyConcurrentLinkedQueue {
    private AtomicReference<Node> first = new AtomicReference<>(null);
    private AtomicReference<Node> last = new AtomicReference<>(null);
    private AtomicInteger size = new AtomicInteger(0);

    public AtomicInteger getSize() {
        return size;
    }

    public void add(int data) {
        Node newNode = new Node();
        newNode.data = data;

        while (true) {

            //head and tail can be accessed by thread which created them on it's local stack
            Node head = first.get();

            // if queue is empty than no consumer can take its elements
            if (head == null) {
                if (first.compareAndSet(head, newNode)) {
                    last.set(newNode);
                    size.incrementAndGet();
                    break;
                } else {
                    continue;
                }
            }

            newNode.next = head;
            if (first.compareAndSet(head, newNode)) {
                size.incrementAndGet();
                break;
            } else {
                newNode.next = null;
                continue;
            }
        }
    }

    public Integer remove() {
        while (true) {
            Node head = first.get();
            Node tail = last.get();

            // empty queue
//            if (head == null) {
            if (tail == null) {
                return null;
            }

            // exactly one element in queue
            if (head == tail) {
                if (first.compareAndSet(head, null)) {
                    last.set(null);
                    size.decrementAndGet();
                    return tail.data;
                } else {
                    continue;
                }
            }

            Node temp = head;
            while (temp != null && temp.next != tail) {
                temp = temp.next;
            }

            // other thread did some concurrent modification
            if (temp == null) {
                continue;
            }

            if (last.compareAndSet(temp.next, temp)) {
                temp.next = null;
                size.decrementAndGet();
                System.out.println("success");
                return tail.data;
            } else {
                continue;
            }
        }
    }

    private static class Node {
        int data;
        Node next;
    }
}

class Producer extends Thread {
    MyConcurrentLinkedQueue queue;

    public Producer(MyConcurrentLinkedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20_000; i++) {
            queue.add(i);
        }
    }
}

class Consumer extends Thread {
    MyConcurrentLinkedQueue queue;

    public Consumer(MyConcurrentLinkedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10_000) {
            if (queue.remove() != null) {
                i++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyConcurrentLinkedQueue queue = new MyConcurrentLinkedQueue();
        Thread producer1 = new Producer(queue);
        Thread producer2 = new Producer(queue);

        Thread consumer1 = new Consumer(queue);
        Thread consumer2 = new Consumer(queue);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer2.join();

        System.out.println(queue.getSize().get());
    }
}
