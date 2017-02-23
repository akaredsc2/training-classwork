package org.vitaly.week04.lesson11.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vitaly on 22.02.17.
 */

class A {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return value == a.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<A, Integer> map = new HashMap<>();
        A pa = new A();
        pa.setValue(10);
        map.put(pa, 100);

        System.out.println(map.get(pa));
        pa.setValue(25);
        System.out.println(map.get(pa));
    }
}
