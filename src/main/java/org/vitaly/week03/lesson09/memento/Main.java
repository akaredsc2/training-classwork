package org.vitaly.week03.lesson09.memento;

/**
 * Created by vitaly on 17.02.17.
 */

class A {
    int a;
    int b;
    int c;
    int d;

    public A(int a, int b) {
        this.a = a;
        this.b = b;
        this.c = a + b;
        this.d = a - b;
    }

    public Memento saveState() {
        Memento memento = new Memento(a, b);
        return memento;
    }

    public void restoreState(Memento memento) {
        this.a = memento.getA();
        this.b = memento.getB();
        this.c = a + b;
        this.d = a - b;
    }
}

class Memento {
    int a;
    int b;

    public Memento(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class Main {
    public static void main(String[] args) {
        A pa = new A(10, 20);
        Memento memento = pa.saveState();
        pa = null;
        A pa1 = new A(1, 4);
        pa1.restoreState(memento);
    }
}
