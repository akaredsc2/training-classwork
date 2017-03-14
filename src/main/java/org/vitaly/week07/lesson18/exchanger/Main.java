package org.vitaly.week07.lesson18.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by vitaly on 13.03.17.
 */

class MyThread extends Thread {
    Exchanger<Integer> exchanger;
    Integer i;

    public MyThread(Exchanger<Integer> exchanger, Integer i) {
        this.exchanger = exchanger;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            Integer i1 = exchanger.exchange(i);
            System.out.println(i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        MyThread myThread1 = new MyThread(exchanger, 10);
        MyThread myThread2 = new MyThread(exchanger, 20);

        System.out.println(myThread1.i);
        System.out.println(myThread2.i);

        myThread1.start();
        myThread2.start();

        System.out.println(myThread1.i);
        System.out.println(myThread2.i);
    }
}
