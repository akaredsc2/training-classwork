package org.vitaly.week05.lesson14.deadlock;

/**
 * Created by vitaly on 01.03.17.
 */

class MyThread extends Thread {
    Object object1;
    Object object2;

    public MyThread(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            synchronized (object2) {

            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new MyThread(object1, object2);
        Thread thread2 = new MyThread(object2, object1);
        thread1.start();
        thread2.start();
    }
}
