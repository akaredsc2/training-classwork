package org.vitaly.week07.lesson19.threadPool;

import java.util.concurrent.*;

/**
 * Created by vitaly on 15.03.17.
 */

class Sum implements Callable<Integer> {
    int begin;
    int end;

    public Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = begin; i < end; i += 1) {
            result += i;
        }
        return result;
    }
}


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Sum sum1 = new Sum(0, 500000);
        Sum sum2 = new Sum(500000, 700000);
        Sum sum3 = new Sum(700000, 1000001);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executorService.submit(sum1);
        Future<Integer> future2 = executorService.submit(sum2);
        Future<Integer> future3 = executorService.submit(sum3);

        while (!(future1.isDone() && future2.isDone() && future3.isDone())) {
            System.out.println("waiting");
        }

        int total = future1.get() + future2.get() + future3.get();

        System.out.println(total);

        executorService.shutdown();
    }
}
