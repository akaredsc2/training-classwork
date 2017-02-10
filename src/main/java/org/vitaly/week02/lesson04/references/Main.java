package org.vitaly.week02.lesson04.references;

import java.lang.ref.*;

/**
 * Created by root on 06.02.17.
 */

class A {

}

public class Main {
    public static void main(String[] args) {
        //strong reference
        A pa = new A();

        //soft reference
        Reference<A> rs = new SoftReference<>(pa); //uses native code
        pa = null;
        System.gc(); // not garaunteed that rs references to anything

        A pa1 = rs.get();
        if (pa1 == null) {
            pa1 = new A();
        }

        Reference<A> rw = new WeakReference<>(pa1);
        pa1 = null;
        System.gc();
        A pa2 = rw.get();
        if (pa2 == null) {
            pa2 = new A();
        }

        A pa3 = new A();
        ReferenceQueue<A> rq = new ReferenceQueue<>();
        Reference<A> rp = new PhantomReference<>(pa3, rq);
        pa3 = null;
        System.out.println(rq.poll());
        System.gc();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        System.out.println(rq.poll());
    }
}
