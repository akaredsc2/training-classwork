package org.vitaly.week01.lesson03.localClassImplemeningInterface;

class A {
    int aa = 40;

    public C fA() {
        int a = 10;
        class B implements C {
            int b = 20;
            int a = 110;

            public void fB() {
                a = 100;
            }
        }
        B pb = new B();
        return pb;
    }
}

interface C {
    void fB();
}

public class Main {
    public static void main(String[] args) {
        A pa = new A();
        C o = pa.fA();
        o.fB();
    }
}
