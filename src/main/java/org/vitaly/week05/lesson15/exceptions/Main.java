package org.vitaly.week05.lesson15.exceptions;

/**
 * Created by vitaly on 03.03.17.
 */

class MyHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Here");
        e.printStackTrace();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        if (true) {
            throw new RuntimeException("My thread thrown exception");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyHandler());
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
