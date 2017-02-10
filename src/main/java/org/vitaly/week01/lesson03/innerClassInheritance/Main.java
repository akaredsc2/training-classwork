package org.vitaly.week01.lesson03.innerClassInheritance;

class A {
    private static int aa = 20;
    private int a = 10;

    class B {
        private int b = 30;

        public void fB() {
            A.this.a = 300;
            B.this.b = 50;
        }
    }

    public void fA() {
        B pb = this.new B();
        pb.fB();
    }
}

class C extends A.B {
    static A pa = new A();

    public C() {
        pa.super();
    }
}

public class Main {
    public static void main(String[] args) {
        A pa = new A();
        A.B pb = pa.new B();
    }
}
