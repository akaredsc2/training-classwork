package org.vitaly.week04.lesson10.templateMethod;

/**
 * Created by vitaly on 20.02.17.
 */

class Common {
    public void algorithm() {
        System.out.println("common part");
    }
}

class AlgorithmA extends Common {
    public void algorithm() {
        System.out.println("algorithmA1");
        super.algorithm();
        System.out.println("algorithmA2");
    }
}

class AlgorithmB extends Common {
    public void algorithm() {
        System.out.println("algorithmB1");
        super.algorithm();
        System.out.println("algorithmB2");
    }
}

public class Main {
    public static void main(String[] args) {
        Common common = new AlgorithmA();
        common.algorithm();
    }
}
