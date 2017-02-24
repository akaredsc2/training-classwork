package org.vitaly.week04.lesson12.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by vitaly on 24.02.17.
 */

interface A {
    int f(int a, int b);
}

class B implements A {
    @Override
    public int f(int a, int b) {
        return a + b;
    }
}

class MyProxy implements InvocationHandler {
    private A pa;

    public MyProxy(A pa) {
        this.pa = pa;
    }

    public A getInstance() {
        return (A) Proxy.newProxyInstance(pa.getClass().getClassLoader(), pa.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("f")) {
            int a = (int) args[0] << 1;
            int b = (int) args[1] << 1;
            return method.invoke(pa, a, b);
        }
        return method.invoke(pa, args);
    }
}

public class Main {
    public static void main(String[] args) {
        A pa = new B();
        MyProxy proxy = new MyProxy(pa);
        int result = proxy.getInstance().f(10, 20);
        System.out.println(result);
    }
}
