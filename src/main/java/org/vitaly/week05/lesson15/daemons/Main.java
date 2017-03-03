package org.vitaly.week05.lesson15.daemons;

/**
 * Created by vitaly on 03.03.17.
 */

class MyThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("spam");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        Thread.sleep(100);
    }
}
