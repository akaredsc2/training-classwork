package org.vitaly.week02.lesson04.clone2;

/**
 * Created by root on 06.02.17.
 * <p>
 * How-to clone:
 * copying constructor or clone() method
 */

class A implements Cloneable { /* Cloneable is marker interface. If not implemented, then you'll get CloneNotSupportedException*/

    int a;
    int[] arr;

    public A() {
    }

    /**
     * copying constructor
     *
     * @param pa object to be copied
     */
    public A(A pa) {
    }

    /*
     * marker interfaces are not used anymore because of annotations
     */
    /* public A clone() {
        A copy = new A();
        copy.a = this.a;
//        copy.arr = this.arr; shallow copy
        copy.arr = this.arr.clone(); //deep copy
        return copy;
    } */

    //restricts using of clone() method
    public A clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

public class Main {
}
