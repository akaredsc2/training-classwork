package org.vitaly.week06.lesson17.linkedBlockingQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by vitaly on 10.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        queue.poll();
        queue.poll();
        queue.poll();
    }
}
