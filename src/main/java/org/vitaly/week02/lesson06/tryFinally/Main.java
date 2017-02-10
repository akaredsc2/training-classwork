package org.vitaly.week02.lesson06.tryFinally;

import java.io.Closeable;

/**
 * Created by root on 10.02.17.
 */

class A implements Closeable {
    public void f(int a) {
        if (a == 0) {
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}

public class Main {
    public static void main(String[] args) {
        /*
        A pa = new A();
        try {
            pa.f(0);
        } finally {
            System.out.println("finally");
        }
        */

        try(A pa = new A()) {
            pa.f(0);
        }

        A pa1 = new A();
        try {
            pa1.f(0);
        } finally {
            pa1.close();
        }
    }
}
