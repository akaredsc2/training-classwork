package org.vitaly.week08.lesson21.regex;

import java.util.Arrays;

/**
 * Created by vitaly on 20.03.17.
 */
public class Main {
    public static void main(String[] args) {
//        String s = "helloaaafffaaaarerbbbqwerbbbbzxc";
//        String[] array = s.split("[ab]+");
        String s = "helloaaafffaaaarerbbbqwerbbbbzxcabbababaskdhkfhsdklfhdkjfhkdjs";
        String[] array = s.split("([ab])\\1*");
        System.out.println(Arrays.toString(array));
    }
}
