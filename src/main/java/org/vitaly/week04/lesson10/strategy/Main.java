package org.vitaly.week04.lesson10.strategy;

/**
 * Created by vitaly on 20.02.17.
 */

abstract class Strategy {
    abstract void sort();
}

class InsertSort extends Strategy {
    public void sort() {
        System.out.println("insert sort");
    }
}

class QuickSort extends Strategy {
    public void sort() {
        System.out.println("quick sort");
    }
}

public class Main {
    public static void f(Strategy strategy) {
        strategy.sort();
    }

    public static void main(String[] args) {
        Strategy strategy = new InsertSort();
        f(strategy);
    }
}
