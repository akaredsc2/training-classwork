package org.vitaly.week02.lesson06.exceptionsWithInharitance;

/**
 * Created by root on 10.02.17.
 */

class MyException extends Exception {

}

class MyException1 extends Exception {

}

class A {
    public void f(int a) throws MyException {
        if (a == 0) {
            throw new MyException();
        }
    }
}

class B extends A {
//    public void f(int a) throws MyException1 { //thanks god it's impossible
//        throw new MyException1();
//    }
}

public class Main {
    public static A g() {
        return new B();
    }

    public static void main(String[] args) {
        A pa = g();
        try {
            pa.f(0);
        } catch (MyException e) {

        }
    }
}
