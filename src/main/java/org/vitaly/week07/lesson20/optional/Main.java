package org.vitaly.week07.lesson20.optional;

import java.util.Optional;

/**
 * Created by vitaly on 17.03.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String s = "hello";
//        s = null;
        Optional<String> element = Optional.ofNullable(s);
//        element.get(); bad
        element.orElseThrow(Exception::new);
        element.ifPresent(System.out::println);
    }
}
