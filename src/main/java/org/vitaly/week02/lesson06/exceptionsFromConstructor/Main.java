package org.vitaly.week02.lesson06.exceptionsFromConstructor;

/**
 * Created by root on 10.02.17.
 */

class A {
    public static A instance;

    int b;
    int c;

    public A(int a) throws Exception {
        instance = this;
        b = 10;
        if (a == 0) {
            throw new Exception();
        }
        c = a;
    }
}

public class Main {
    public static void main(String[] args) {
        A pa = null;
        try {
            pa = new A(0);
        } catch (Exception e) {

        }

        //hello kinda memory leak
        System.out.println(pa);
        System.out.println(A.instance);
    }
}
