package org.vitaly.week05.lesson15.assertion;

/**
 * Created by vitaly on 03.03.17.
 */
public class Main {
    public static void main(String[] args) {
        int a = 10;

        // need -ea virtual machine option
        assert (a > 10) : "error";
    }
}
