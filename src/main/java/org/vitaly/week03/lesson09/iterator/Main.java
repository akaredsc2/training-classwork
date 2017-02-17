package org.vitaly.week03.lesson09.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vitaly on 17.02.17.
 */

class MyCollection implements Iterable<String> {
    List<String> list = new ArrayList<>();

    public void add(String string) {
        list.add(string);
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    class MyIterator implements java.util.Iterator<String> {
        int current = -1;

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public String next() {
            return list.get(++current);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        MyCollection m = new MyCollection();
        m.add("10");
        m.add("20");
        m.add("30");
        for (String s : m) {
            System.out.println(s);
        }
    }
}
