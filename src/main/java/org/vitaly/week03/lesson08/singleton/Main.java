package org.vitaly.week03.lesson08.singleton;

/**
 * Created by vitaly on 15.02.17.
 */
class Singleton {
    //    private static Singleton instance = new Singleton(); // threadsafe if one class loader
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
//        if (instance == null) { // no need if static initialization used
//            instance = new Singleton();
//        }
        return instance;
    }
}

public class Main {
}
