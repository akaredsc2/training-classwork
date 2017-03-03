package org.vitaly.week05.lesson15.threadLocal;

/**
 * Created by vitaly on 03.03.17.
 */

class MyThread extends Thread {
    private int value;
    private ThreadLocal<Integer> threadLocal;

    public MyThread(ThreadLocal<Integer> threadLocal, int value) {
        this.threadLocal = threadLocal;
        this.value = value;
    }

    @Override
    public void run() {
        this.threadLocal.set(value);
        System.out.println(threadLocal.get());
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        MyThread myThread1 = new MyThread(integerThreadLocal, 100);
        MyThread myThread2 = new MyThread(integerThreadLocal, 200);
        myThread1.start();
        myThread2.start();
    }
}
