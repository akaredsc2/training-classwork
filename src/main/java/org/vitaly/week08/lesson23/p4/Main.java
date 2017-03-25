package org.vitaly.week08.lesson23.p4;

import java.io.*;

/**
 * Created by vitaly on 24.03.17.
 */
class MyClass implements Serializable {
    private static final long serialVersionUID = 238;

    int a;
    int b;

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
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
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyClass myClass = new MyClass(10, 20);
        String pathname = "serialization4.txt";

        File file = new File(pathname);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(myClass);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(pathname);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        MyClass myClass1 = (MyClass) objectInputStream.readObject();

        System.out.println(myClass1.getA());
        System.out.println(myClass1.getB());
        fileInputStream.close();
        objectInputStream.close();
    }
}

