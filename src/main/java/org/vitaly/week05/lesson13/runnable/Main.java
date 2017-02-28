package org.vitaly.week05.lesson13.runnable;

/**
 * Created by vitaly on 27.02.17.
 */

//better cause you can extend other classes
class Sum implements Runnable {
    private int begin;
    private int end;
    private long result;

    public Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.result = 0;
    }

    public long getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            result += i;
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sum sum1 = new Sum(1, 50000);
        Sum sum2 = new Sum(50000, 100001);

        Thread thread1 = new Thread(sum1);
        Thread thread2 = new Thread(sum2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long total = sum1.getResult() + sum2.getResult();
        System.out.println(total);
    }
}
