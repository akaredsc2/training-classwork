package org.vitaly.week04.lesson12.di;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by vitaly on 24.02.17.
 */

interface MyInterface {
    void f();
}

class A {
    MyInterface myInterface;

    public void g() {
        myInterface.f();
    }
}

class B implements MyInterface {
    @Override
    public void f() {
        System.out.println("B");
    }
}

class C implements MyInterface {
    @Override
    public void f() {
        System.out.println("C");
    }
}

class Factory {
    public static A getInstance(String fileName) throws
            IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchFieldException {
        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String[] elements = bufferedReader.readLine().split(":");
        Class cA = Class.forName(elements[0]);
        A pa = (A) cA.newInstance();
        Field field = cA.getDeclaredField(elements[1]);
        field.setAccessible(true);
        Class c = Class.forName(elements[2]);
        Object o = c.newInstance();
        field.set(pa, o);
        bufferedReader.close();
        return pa;
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, IOException {
        A pa = Factory.getInstance("config.txt");
        pa.g();
    }
}
