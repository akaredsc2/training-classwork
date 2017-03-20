package org.vitaly.week07.lesson20.parallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by vitaly on 17.03.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        Stream<Integer> stream = list.parallelStream();

        stream.map(x -> x << 1).forEach(System.out::println);
    }
}
