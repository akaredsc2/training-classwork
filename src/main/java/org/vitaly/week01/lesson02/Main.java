package org.vitaly.week01.lesson02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 01.02.17.
 */
interface Container extends Cloneable {
    Container clone();

    int size();

    int get(int index);

    boolean contains(int element);

    void add(int element);
}

class Set {
    private Container c;

    public Set(Container cont) {
        this.c = cont.clone();
    }

    public Set union(Set other) {
        Set result = new Set(this.c);
        for (int i = 0; i < other.c.size(); i++) {
            int element = other.c.get(i);
            if (!result.c.contains(element)) {
                result.c.add(element);
            }
        }
        return result;
    }
}

class MyArray implements Container {
    List<Integer> l = new ArrayList<>();

    @Override
    public Container clone() {
        MyArray myArray = new MyArray();
        for (int elm : l) {
            myArray.add(elm);
        }
        return myArray;
    }

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public int get(int index) {
        return l.get(index);
    }

    @Override
    public boolean contains(int element) {
        return l.contains(element);
    }

    @Override
    public void add(int element) {
        l.add(element);
    }
}

public class Main {
    public static void main(String[] args) {
        MyArray myArray1 = new MyArray();
        myArray1.add(10);
        myArray1.add(20);
        Set set1 = new Set(myArray1);
        MyArray myArray2 = new MyArray();
        myArray2.add(30);
        myArray2.add(40);
        Set set2 = new Set(myArray2);
        Set set3 = set1.union(set2);
    }
}
