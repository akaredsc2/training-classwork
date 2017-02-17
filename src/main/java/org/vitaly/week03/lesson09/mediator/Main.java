package org.vitaly.week03.lesson09.mediator;

/**
 * Created by vitaly on 17.02.17.
 */

class A {
    Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message, Class clazz) {
        mediator.sendMessage(message, clazz);
    }

    public void recieveMessage(String message) {
        System.out.println(message);
    }
}

class B {
    Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message, Class clazz) {
        mediator.sendMessage(message, clazz);
    }

    public void receiveMessage(String message) {
        System.out.println(message);
    }
}

class C {
    Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message, Class clazz) {
        mediator.sendMessage(message, clazz);
    }

    public void receiveMessage(String message) {
        System.out.println(message);
    }
}

class Mediator {
    A pa = new A();
    B pb = new B();
    C pc = new C();

    public void setPa(A pa) {
        this.pa = pa;
    }

    public void setPb(B pb) {
        this.pb = pb;
    }

    public void setPc(C pc) {
        this.pc = pc;
    }

    public void sendMessage(String message, Class clazz) {
        switch (clazz.getName()) {
            case "A":
                pa.recieveMessage(message);
                break;
            case "B":
                pb.receiveMessage(message);
                break;
            case "C":
                pc.receiveMessage(message);
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        A pa = new A();
        B pb = new B();
        C pc = new C();
        Mediator mediator = new Mediator();

        mediator.setPa(pa);
        mediator.setPb(pb);
        mediator.setPc(pc);

        pa.setMediator(mediator);
        pb.setMediator(mediator);
        pc.setMediator(mediator);

        pb.sendMessage("adfdgfd", pa.getClass());
    }
}
