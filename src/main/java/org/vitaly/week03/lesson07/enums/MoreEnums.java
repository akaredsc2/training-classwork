package org.vitaly.week03.lesson07.enums;

/**
 * Created by vitaly on 13.02.17.
 */

enum Operations {
    PLUS {
        //        public int c = 100; baaad
        public int operation(int a, int b) {
            return a + b;
        }
    },
    MINUS {
        public int operation(int a, int b) {
            return a - b;
        }
    };

    public abstract int operation(int a, int b);
}

//kind of equivalent code for enums
abstract class Operations1 {
    public static final Operations1 PLUS = new Plus();
    public static final Operations1 MINUS = new Minus();

    public abstract int operation(int a, int b);
}

class Plus extends Operations1 {
    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}

class Minus extends Operations1 {
    @Override
    public int operation(int a, int b) {
        return a - b;
    }
}

public class MoreEnums {
    public static void main(String[] args) {
        Operations e = Operations.PLUS;
        int res = e.operation(10, 20);
        System.out.println(res);

        for (Operations element : Operations.values()) {
            System.out.println(element.operation(10, 20));
        }
    }
}
