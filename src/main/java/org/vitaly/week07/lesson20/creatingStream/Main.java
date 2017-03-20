package org.vitaly.week07.lesson20.creatingStream;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by vitaly on 17.03.17.
 */

class MyArray implements Spliterator<Integer> {
    Integer[] array;
    int firstPosition;
    int lastPosition;

    protected MyArray() {
    }

    public MyArray(int n) {
        this.array = new Integer[n];
        this.firstPosition = 0;
        this.lastPosition = array.length - 1;
    }

    public void set(int pos, int element) {
        array[pos] = element;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {
        if (firstPosition <= lastPosition) {
            action.accept(array[firstPosition]);
            firstPosition += 1;
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Integer> trySplit() {
        int mid = (lastPosition - firstPosition) / 2;
        if (mid <= 1) return null;

        int newFirstPosition = firstPosition + mid + 1;
        int newLastPosition = lastPosition;
        lastPosition = firstPosition + mid;
        MyArray newArray = new MyArray();
        newArray.array = this.array;
        newArray.firstPosition = newFirstPosition;
        newArray.lastPosition = newLastPosition;
        return newArray;
    }

    @Override
    public long estimateSize() {
        return lastPosition - firstPosition;
    }

    @Override
    public int characteristics() {
        return Spliterator.SIZED | Spliterator.SUBSIZED;
    }

    public Stream<Integer> stream() {
        firstPosition = 0;
        lastPosition = array.length - 1;
        return StreamSupport.stream(this, false);
    }

    public Stream<Integer> parallelStream() {
        firstPosition = 0;
        lastPosition = array.length - 1;
        return StreamSupport.stream(this, true);
    }
}

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(6);
        myArray.set(0, 10);
        myArray.set(1, 20);
        myArray.set(2, 30);
        myArray.set(3, 40);
        myArray.set(4, 50);
        myArray.set(5, 60);

        myArray.stream().map(x -> x * 2).forEach(System.out::println);
        myArray.parallelStream().map(x -> x * 3).forEach(System.out::println);
    }
}
