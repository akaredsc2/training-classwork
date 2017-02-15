package org.vitaly.week03.lesson08.proxy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vitaly on 15.02.17.
 */

abstract class Component {
    public abstract int operation(int a, int b);
}

class Sum extends Component {
    @Override
    public int operation(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
}

class ProxySum extends Component {
    Component component = new Sum();
    Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    @Override
    public int operation(int a, int b) {
        Integer result = cache.get(new Pair<>(a, b));
        if (result == null) {
            result = component.operation(a, b);
            cache.put(new Pair<>(a, b), result);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Component c = new ProxySum();
        c.operation(10, 20);
        System.out.println("boom");
        c.operation(10, 20);
        System.out.println("cache");
    }
}
