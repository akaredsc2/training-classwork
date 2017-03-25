package org.vitaly.week08.lesson23.serializableOverride1;

import java.io.*;

/**
 * Created by vitaly on 24.03.17.
 */

class A implements Serializable {
    int a;
    int b;

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

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        System.out.println("called write");
        objectOutputStream.writeInt(a);
        objectOutputStream.writeInt(b);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        System.out.println("called read");
        a = objectInputStream.readInt();
        b = objectInputStream.readInt();
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
        fileInputStream.close();
        objectInputStream.close();
    }
}
