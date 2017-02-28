package org.vitaly.week05.lesson13.sum;

/**
 * Created by vitaly on 27.02.17.
 */

class Sum extends Thread {
    private int begin;
    private int end;
    private long result;

    /*
    //prevent jvm from optimization
    volatile private boolean isFinished;
    */
    public Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.result = 0;
//        this.isFinished = false;
    }

    public long getResult() {
        return result;
    }

    /*
        public boolean isFinished() {
            return isFinished;
        }
    */
    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            result += i;
        }
//        isFinished = true;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sum sum1 = new Sum(1, 50000);
        Sum sum2 = new Sum(50000, 100001);

        sum1.start();
        sum2.start();

        //stops Main thread till sum1 and sum2 are finished
        sum1.join();
        sum2.join();

        /*
        Bad cause Main doesn't do a thing, just waiting

        //jvm can optimize making method returns constant value so loop will never break
        while (!sum1.isFinished() || !sum2.isFinished()) {

            // prevents from hanging. Jvm won't even try to optimize
            System.out.println(sum1.isFinished());
            System.out.println(sum2.isFinished());
        }
        */
        long total = sum1.getResult() + sum2.getResult();
        System.out.println(total);
    }
}
