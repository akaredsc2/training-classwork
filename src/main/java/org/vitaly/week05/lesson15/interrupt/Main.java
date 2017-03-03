package org.vitaly.week05.lesson15.interrupt;

/**
 * Created by vitaly on 03.03.17.
 */

class MyThread extends Thread {
    @Override
    public void run() {

//        while (!interrupted()) {
        while (!isInterrupted()) {

//            System.out.println("MyThread is working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

//                e.printStackTrace();

//                Equivalent in this situation
//                Thread.currentThread().interrupt();
                this.interrupt();
            }
        }
        System.out.println("We are here");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.interrupt();
    }
}
