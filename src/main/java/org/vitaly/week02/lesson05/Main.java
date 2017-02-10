package org.vitaly.week02.lesson05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 08.02.17.
 */
interface Container<T extends Comparable<? super T>> extends Cloneable{
    Container<T> clone();
    int size();
    T get(int index);
    boolean contains(T element);
    void add(T element);
}

class MyArray<T extends Comparable<? super T>> implements Container<T>{
    List<T> elements = new ArrayList<>();
    public Container<T> clone(){
        Container<T> copy = new MyArray<T>();
        for(T element: elements){
            copy.add(element);
        }
        return copy;
    }
    @Override
    public int size() {
        return elements.size();
    }
    @Override
    public T get(int index) {
        return elements.get(index);
    }
    @Override
    public boolean contains(T element) {
        for(T elem : elements){
            if(elem.compareTo(element)==0) return true;
        }
        return false;
    }
    @Override
    public void add(T element) {
        elements.add(element);
    }
}

class Set<T extends Comparable<? super T>>{
    Container<T> container;
    public Set(Container<T> container){
        this.container = container;
    }

    public Set<T> union(Set<? extends T > other){
        Set<T> result = new Set<T>(this.container.clone());
        for(int i = 0; i < other.container.size(); i++){
            T element = other.container.get(i);
            if(!result.container.contains(element)){
                result.container.add(element);
            }
        }
        return result;
    }
}

class Table implements Comparable<Table>{
    int high;
    public Table(int high){
        this.high = high;
    }
    public int compareTo(Table other){
        return this.high - other.high;
    }
}
class Chair implements Comparable<Chair>{
    int width;
    public Chair(int width){
        this.width = width;
    }
    public int compareTo(Chair other){
        return this.width - other.width;
    }
}
class Armchair extends Chair{
    public Armchair(int width){
        super(width);
    }
}

public class Main {
    public static void main(String[] args) {
        Container<Table> containerTable = new MyArray<>();
        Table t1 = new Table(23);
        Table t2 = new Table(24);
        containerTable.add(t1);
        containerTable.add(t2);
        Set<Table> tableSet = new Set<>(containerTable);

        Container<Chair> containerChair = new MyArray<>();
        Chair c1 = new Chair(25);
        Chair c2 = new Chair(26);
        containerChair.add(c1);
        containerChair.add(c2);
        Set<Chair> chairSet = new Set<>(containerChair);

        Container<Armchair> containerArmchair = new MyArray<>();
        Armchair a1 = new Armchair(34);
        Armchair a2 = new Armchair(37);
        containerArmchair.add(a1);
        containerArmchair.add(a2);
        Set<Armchair> armchairSet = new Set<>(containerArmchair);

//        tableSet.union(armchairSet);
        chairSet.union(armchairSet);
    }
}