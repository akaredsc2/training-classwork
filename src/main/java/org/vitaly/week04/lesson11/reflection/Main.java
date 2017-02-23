package org.vitaly.week04.lesson11.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by vitaly on 22.02.17.
 */

class A {
    private int value;

    public A() {
    }

    public A(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Class c1 = null;
        try {
            c1 = Class.forName("org.vitaly.week04.lesson11.reflection.A");

            System.out.println(c1);

            Field f = c1.getDeclaredField("value");

            System.out.println(f.getType());
            System.out.println(Modifier.toString(f.getModifiers()));

            A pa = new A();
            f.setAccessible(true);
            f.set(pa, 100);
            System.out.println(pa.getValue());

            Field[] fields = c1.getDeclaredFields();
            System.out.println(Arrays.toString(fields));

            Method method = c1.getDeclaredMethod("setValue", int.class);

            System.out.println(method.getReturnType());

            method.invoke(pa, 300);
            System.out.println(pa.getValue());
        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
