package org.vitaly.week07.lesson19.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by vitaly on 15.03.17.
 */

class Dichotomy extends RecursiveTask<Double> {
    double a;
    double b;
    double eps;

    public Dichotomy(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    public static double f(double x) {
        return x - 2;
    }

    @Override
    protected Double compute() {
        if (Math.abs(a - b) < eps) {
            return a;
        }
        double c = (a + b) / 2;
        if (f(a) * f(c) < 0) {
            Dichotomy dichotomy = new Dichotomy(a, c, eps);
            dichotomy.fork();
            return dichotomy.join();
        } else {
            Dichotomy dichotomy = new Dichotomy(c, b, eps);
            dichotomy.fork();
            return dichotomy.join();
        }
    }
}

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Dichotomy dichotomy = new Dichotomy(-5, 5, 0.01);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Double> future = forkJoinPool.submit(dichotomy);
        System.out.println(future.get());
        forkJoinPool.shutdown();
    }
}
