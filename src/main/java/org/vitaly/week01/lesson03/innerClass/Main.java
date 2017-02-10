package org.vitaly.week01.lesson03.innerClass;

class A {
    int a = 10;
    static int aa = 20;

    public void fA() {
        B.bb = 50;
        B pb = new B();
        pb.b = 100;
    }

    static class B {
        private int b = 30;
        private static int bb = 40;

        public void fB() {
            aa = 35;
        }
    }
}

class C extends A.B {
    public void fC() {
        A.aa = 400000;
    }
}

public class Main {
    public static void main(String[] args) {
        A.B p = new A.B();
    }
}
