package org.vitaly.week07.lesson18.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by vitaly on 13.03.17.
 */

class Student extends Thread {
    CountDownLatch countDownLatch;

    public Student(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("student is waiting for food");
        try {
            countDownLatch.await();
            System.out.println("student is eating");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Chief extends Thread {
    CountDownLatch countDownLatch;

    public Chief(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("chief is cooking");
        try {
            Thread.sleep(200);
            countDownLatch.countDown();
            System.out.println("chief has cooked food");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Student student = new Student(countDownLatch);
        Chief chief1 = new Chief(countDownLatch);
        Chief chief2 = new Chief(countDownLatch);

        student.start();
        chief1.start();
        chief2.start();
    }
}
