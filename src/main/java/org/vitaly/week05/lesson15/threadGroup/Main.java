package org.vitaly.week05.lesson15.threadGroup;

/**
 * Created by vitaly on 03.03.17.
 */

class MyThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadGroup parentThreadGroup = new ThreadGroup("parent");
        ThreadGroup threadGroup = new ThreadGroup(parentThreadGroup, "group1");

        MyThread myThread = new MyThread();
        Thread thread = new Thread(threadGroup, myThread);
        thread.start();
    }
}
