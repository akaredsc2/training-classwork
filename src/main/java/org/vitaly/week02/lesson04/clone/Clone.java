package org.vitaly.week02.lesson04.clone;

/**
 * Created by root on 06.02.17.
 */

/**
 * clone is overridden in arrays. Non other methods of Object are overridden
 */

class B {
    int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class A {
    private B pB;

    public A(B pB) {
        this.pB = pB;
    }
    /* incapsulation broken
    public B getpB() {
        return pB;
    } */

    public void setpB(B pB) {
        this.pB = pB;
    }
}

public class Clone {

}
