package org.vitaly.week07.lesson19.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vitaly on 15.03.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

//        Stream stream = list.stream(); rare

        int result = list.stream()
                .map(x -> x << 1)
                .reduce(0, (a, b) -> a + b);

        System.out.println(result);

        List<Integer> secondList = list.stream()
                .map(x -> x << 1)
                .collect(Collectors.toList());
    }
}
