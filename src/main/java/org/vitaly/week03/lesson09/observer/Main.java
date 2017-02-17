package org.vitaly.week03.lesson09.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 17.02.17.
 */

class Observable {
    int value;
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setValue(int newValue) {
        for (Observer observer : observers) {
            observer.notify(value, newValue);
        }
        value = newValue;
    }
}

interface Observer {
    void notify(int oldValue, int newValue);
}

class MyObserver implements Observer {
    @Override
    public void notify(int oldValue, int newValue) {
        System.out.println(oldValue);
        System.out.println(newValue);
    }
}

public class Main {
    public static void main(String[] args) {
        Observable observable = new Observable();
        Observer observer1 = new MyObserver();
        Observer observer2 = new MyObserver();

        observable.addObserver(observer1);
        observable.addObserver(observer2);

        observable.setValue(20);
    }
}
