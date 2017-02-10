package org.vitaly.week02.lesson06.exceptions;

/**
 * Created by root on 10.02.17.
 */

class MyException extends Exception {
    int i;

    public MyException(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

class MyException1 extends Exception {
    public MyException1(Exception e) {
        super(e);
    }
}

class A {
    public void f(int a) {
        if (a == 0) {
            try {
                throw new MyException(a);
            } catch (MyException e) {

            } catch (Exception e) {

            } finally {

            }
        }
    }

    public void g(int a) throws MyException {
        if (a == 0) {
            throw new MyException(a);
        }
    }

    public void h(int a) throws MyException {
        try {
            if (a == 0 || a == 1) {
                throw new MyException(a);
            }
        } catch (MyException e) {
            if (e.getI() == 0) {
                throw e;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public void i(int a) throws MyException1 {
        try {

            if (a == 0 || a == 1) {
                throw new MyException(a);
            }
        } catch (MyException e) {
            throw new MyException1(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            A pa = new A();
//            pa.g(0);
            pa.i(0);
        } catch (MyException1 e) {
            e.printStackTrace();
        }
    }
}
