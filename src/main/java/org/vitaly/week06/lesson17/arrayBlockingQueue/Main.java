package org.vitaly.week06.lesson17.arrayBlockingQueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by vitaly on 10.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(2);
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
