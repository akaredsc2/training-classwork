package org.vitaly.week08.lesson23.serializableOverride2;

import java.io.*;

/**
 * Created by vitaly on 24.03.17.
 */

class A implements Externalizable {
    int a;
    int b;
    transient int c;

    public A() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("write");
        out.writeInt(a);
        out.writeInt(b);
        out.writeInt(c);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("read");
        a = in.readInt();
        b = in.readInt();
        c = in.readInt();
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A myClass = new A();
        myClass.setA(10);
        myClass.setB(20);
        String pathname = "serialization.txt";
        File file = new File(pathname);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(myClass);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(pathname);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        A myClass1 = (A) objectInputStream.readObject();

        System.out.println(myClass1.getA());
        System.out.println(myClass1.getB());
        System.out.println(myClass1.getC());
        fileInputStream.close();
        objectInputStream.close();
    }
}
