package org.vitaly.week07.lesson18.semaphore;

/**
 * Created by vitaly on 13.03.17.
 */

class Semaphore {
    int count;

    public Semaphore(int count) {
        this.count = count;
    }

    public void acquire() throws InterruptedException {
        synchronized (this) {
            while (count == 0) {
                this.wait();
            }
            count -= 1;
        }
    }

    public void release() {
        synchronized (this) {
            count++;
            this.notifyAll();
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
