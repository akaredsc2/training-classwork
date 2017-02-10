package org.vitaly.week01.lesson03.mutableFieldInInterface;

interface A {

    class B{
        int x = 10;
    }
    B pb = new B();

}

public class Main {
    public static void main(String[] args) {
        A.pb.x = 300;
    }
}
