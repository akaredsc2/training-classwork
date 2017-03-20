package org.vitaly.week08.lesson21.strings;

/**
 * Created by vitaly on 20.03.17.
 */
public class Main {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = new String("hello");
        String s2 = s1.intern();

        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s == s2);

        for (int i = 0; i < 10; i++) {
            s += "askldfjls";
        }

        StringBuilder stringBuilder = new StringBuilder("hello");
        stringBuilder.append("aaa");
    }
}
