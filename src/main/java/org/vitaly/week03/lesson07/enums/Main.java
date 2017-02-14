package org.vitaly.week03.lesson07.enums;

/**
 * Created by vitaly on 13.02.17.
 */

enum MyEnum {
    RED(10), BLACK(20), WHITE(30);

    static int b = 100; //for what?
    int a;


    MyEnum(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

public class Main {
    //    public static void f(String string) {
    public static void f(MyEnum string) {

    }

    public static void main(String[] args) {
        MyEnum e = MyEnum.BLACK;
        System.out.println(e.ordinal());
        System.out.println(e.getA());
    }
}
