package org.vitaly.week01.lesson03.lambda;

interface A {
    void fA(int a, int b);
}

class B {
    public static void fB(int a, int b) {
        System.out.println(a - b);
    }
}

class C {
    public void fC(int a, int b) {
        System.out.println(a * b);
    }
}

public class Main {
    public static void main(String[] args) {
        A pa = (a, b) -> {
            System.out.println(a + b);
        };
        pa.fA(10, 20);

        class NoName implements A {
            public void fA(int a, int b) {
                System.out.println("A");
            }
        }
        A pa1 = new NoName();
        pa1.fA(20, 30);

        A pa2 = B::fB;

        class NoName1 implements A {
            public void fA(int a, int b) {
                B.fB(a, b);
            }
        }

        A pa3 = new NoName1();
        pa3.fA(10, 20);
        pa2.fA(30, 40);

        C pc = new C();
        A pa4 = pc::fC;

        class NoName2 implements A {
            C pc;

            public NoName2(C pc) {
                this.pc = pc;
            }

            public void fA(int a, int b) {
                pc.fC(a, b);
            }
        }
    }
}
