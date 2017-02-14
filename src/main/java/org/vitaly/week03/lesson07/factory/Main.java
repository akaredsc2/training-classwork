package org.vitaly.week03.lesson07.factory;

/**
 * Created by vitaly on 13.02.17.
 */

enum Factories {
    TRIANGLE_FACTORY, CIRCLE_FACTORY
}

class Factory {
    public static GeometryFigureFactory getFactory(Factories factory) {
        switch (factory) {
            case TRIANGLE_FACTORY:
                return TriangleFactory.getInstance();
            case CIRCLE_FACTORY:
                return CircleFactory.getInstance();
        }
        return null;
    }
}

abstract class GeometryFigureFactory {
    public abstract Shape getShape();
}

class TriangleFactory extends GeometryFigureFactory {

    //singleton without making it singleton
    static GeometryFigureFactory instance = new TriangleFactory();
    Shape figure = new Triangle();

    public static GeometryFigureFactory getInstance() {
        return instance;
    }

    @Override
    public Shape getShape() {
//        return new Triangle();
        return figure;
    }
}

class CircleFactory extends GeometryFigureFactory {
    static GeometryFigureFactory instance = new CircleFactory();

    public static GeometryFigureFactory getInstance() {
        return instance;
    }

    @Override
    public Shape getShape() {
        return new Circle();
    }
}

abstract class Shape {
    abstract public void show();
}

class Triangle extends Shape {
    @Override
    public void show() {
        System.out.println("triangle, bitch");
    }
}

class Circle extends Shape {
    @Override
    public void show() {
        System.out.println("circle, bitch");
    }
}

public class Main {
    public static void main(String[] args) {
        GeometryFigureFactory factory = Factory.getFactory(Factories.CIRCLE_FACTORY);
        Shape product = factory.getShape();
        product.show();
    }
}
