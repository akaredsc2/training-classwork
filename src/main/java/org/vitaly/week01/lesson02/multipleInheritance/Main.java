package org.vitaly.week01.lesson02.multipleInheritance;

/**
 * Created by vitaly on 10.02.17.
 */
interface A {
    int a = 10;

    void f();

    default void g() {
    }
}

class C {
    public void g() {
    }
}

class B extends C implements A {
    public void f() {
    }
}

public class Main {
    public static void main(String[] args) {
        B pb = new B();
        pb.g();
    }
}
