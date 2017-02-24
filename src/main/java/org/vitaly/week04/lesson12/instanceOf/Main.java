package org.vitaly.week04.lesson12.instanceOf;

/**
 * Created by vitaly on 24.02.17.
 */

class A {

}

class B {

}

class C extends B {

}

public class Main {
    public static void main(String[] args) {
        A pa = new A();
//        B pb = (B) pa;
//        System.out.println(pa instanceof B);
        B pb = new C();
        System.out.println(pb instanceof C);

        B pb1 = new B();
        System.out.println(pb1 instanceof C);
    }
}
