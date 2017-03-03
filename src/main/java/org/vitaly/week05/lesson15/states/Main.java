package org.vitaly.week05.lesson15.states;

/**
 * Created by vitaly on 03.03.17.
 */

class MyThread extends Thread {
    @Override
    public void run() {
//            Thread.sleep(1000);
        synchronized (this) {
            System.out.println("something");
//                this.wait();

        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        System.out.println(thread.getState());
/*
        thread.start();
        System.out.println(thread.getState());

        Thread.sleep(10);
        System.out.println(thread.getState());

        Thread.sleep(2000);
        System.out.println(thread.getState());
        */
        synchronized (thread) {
            thread.start();
            Thread.sleep(100);
            System.out.println(thread.getState() == Thread.State.BLOCKED);
        }
    }
}
