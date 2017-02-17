package org.vitaly.week03.lesson09.facade;

/**
 * Created by vitaly on 17.02.17.
 */

class Car {
    protected void igniteEngine() {

    }

    protected void pushClutch() {

    }

    protected void pushGas() {

    }

    public void move() {
        igniteEngine();
        pushClutch();
        pushGas();
    }
}

public class Main {
}
