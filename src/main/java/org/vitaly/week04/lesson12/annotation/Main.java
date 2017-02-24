package org.vitaly.week04.lesson12.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by vitaly on 24.02.17.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value();
}

//@MyAnnotation(value = "hello")
class A {
    @MyAnnotation(value = "123")
    public void f() {
        Class c = this.getClass();
        try {
            Method f = c.getDeclaredMethod("f");
            MyAnnotation myAnnotation = (MyAnnotation) f.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class c = Class.forName("org.vitaly.week04.lesson12.annotation.A");
//        MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
//        System.out.println(myAnnotation.value());

        A pa = new A();
        pa.f();
    }
}
