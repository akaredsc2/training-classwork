package org.vitaly.week07.lesson18.barrier;

/**
 * Created by vitaly on 13.03.17.
 */

class Barrier {
    int count;

    public Barrier(int count) {
        this.count = count;
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            count -= 1;
            while (count > 0) {
                this.wait();
            }
            this.notifyAll();
//            count += 1; for cyclic
        }
    }
}

public class Main {
}
