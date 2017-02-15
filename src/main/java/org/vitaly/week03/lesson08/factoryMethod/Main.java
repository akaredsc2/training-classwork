package org.vitaly.week03.lesson08.factoryMethod;

/**
 * Created by vitaly on 15.02.17.
 */

class A {
    int a;

    private A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static A createInstance(int a) {
        if (a == 0) {
            throw new IllegalArgumentException();
        }
        return new A(a);
    }
}

public class Main {
    public static void main(String[] args) {
        A pa = A.createInstance(10);
    }
}
