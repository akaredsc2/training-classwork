package org.vitaly.week08.lesson23.inheritanceAndSeriazlization;

import java.io.*;

/**
 * Created by vitaly on 24.03.17.
 */

class A {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

class B extends A implements Serializable {
    int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B myClass = new B();
        myClass.setA(10);
        myClass.setB(20);
        String pathname = "serialization3.txt";
        File file = new File(pathname);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(myClass);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(pathname);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        B myClass1 = (B) objectInputStream.readObject();

        System.out.println(myClass1.getA());
        System.out.println(myClass1.getB());
        fileInputStream.close();
        objectInputStream.close();
    }
}
