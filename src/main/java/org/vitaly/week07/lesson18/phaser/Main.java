package org.vitaly.week07.lesson18.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by vitaly on 13.03.17.
 */

class MyThread extends Thread {
    Phaser phaser;

    public MyThread(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.register();
        System.out.println("thread is registered");
    }
}

class MyThread1 extends Thread {
    Phaser phaser;

    public MyThread1(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        System.out.println("thread is deregistered");
    }
}

class MyThread2 extends Thread {
    Phaser phaser;

    public MyThread2(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.arrive();
        System.out.println("thread is arrived");
    }
}

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        MyThread myThread = new MyThread(phaser);
        MyThread1 myThread11 = new MyThread1(phaser);
        MyThread1 myThread12 = new MyThread1(phaser);
        MyThread1 myThread13 = new MyThread1(phaser);
//        MyThread1 myThread14 = new MyThread1(phaser);
        MyThread2 myThread5 = new MyThread2(phaser);

        myThread.start();
        myThread11.start();
        myThread12.start();
//        myThread13.start();

//        myThread14.start();
        myThread5.start();
    }
}
