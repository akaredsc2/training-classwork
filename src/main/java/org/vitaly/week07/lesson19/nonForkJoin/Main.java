package org.vitaly.week07.lesson19.nonForkJoin;

import static java.lang.Math.*;

/**
 * Created by vitaly on 15.03.17.
 */

class Dichotomy extends Thread {
    double a;
    double b;
    double eps;
    double result;

    public Dichotomy(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    public static double f(double x) {
        return x - 2;
    }

    @Override
    public void run() {
        if (abs(a - b) < eps) {
            result = a;
        }

        double c = (a + b) / 2;
        if (f(a) * f(c) < 0) {
            Dichotomy dichotomy = new Dichotomy(a, c, eps);
            dichotomy.start();
            try {
                dichotomy.join();
                result = dichotomy.result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            Dichotomy dichotomy = new Dichotomy(c, b, eps);
            dichotomy.start();
            try {
                dichotomy.join();
                result = dichotomy.result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dichotomy dichotomy = new Dichotomy(-5, 5, 0.01);
        dichotomy.start();
        dichotomy.join();
        System.out.println(dichotomy.result);
    }
}
