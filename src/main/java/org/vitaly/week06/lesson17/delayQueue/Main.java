package org.vitaly.week06.lesson17.delayQueue;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 10.03.17.
 */

class A implements Delayed {
    private int value;
    private long delayTime;

    public A(int value, long delayTime) {
        this.value = value;
        this.delayTime = delayTime + System.currentTimeMillis();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(), unit);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.delayTime, ((A) o).delayTime);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        A pa1 = new A(100, 1000);
        A pa2 = new A(200, 1500);
        A pa3 = new A(300, 2000);

        Queue<A> queue = new DelayQueue<>();

        queue.offer(pa1);
        queue.offer(pa2);
        queue.offer(pa3);

        while(true) {
            Thread.sleep(500);
            A poll = queue.poll();
            System.out.println(poll == null ? null : poll.getValue());
        }
    }
}
