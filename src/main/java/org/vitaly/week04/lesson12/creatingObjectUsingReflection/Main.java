package org.vitaly.week04.lesson12.creatingObjectUsingReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vitaly on 24.02.17.
 */

class A {
    int a;

    public A() {
    }

    public A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

public class Main {
    public static void main(String[] args) throws
            ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("org.vitaly.week04.lesson12.creatingObjectUsingReflection.A");
        A pa = (A) c1.newInstance();
        System.out.println(pa.a);

        Constructor constructor = c1.getDeclaredConstructor(int.class);
        A pa1 = (A) constructor.newInstance(10);
    }
}
