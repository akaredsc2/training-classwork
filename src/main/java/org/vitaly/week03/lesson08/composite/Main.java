package org.vitaly.week03.lesson08.composite;

/**
 * Created by vitaly on 15.02.17.
 */

abstract class Component {
    public abstract int calculate();
}

class Number extends Component {
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }
}

class OperationPlus extends Component {
    Component left;
    Component right;

    public OperationPlus(Component left, Component right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
}

class OperationMultiply extends Component {
    Component left;
    Component right;

    public OperationMultiply(Component left, Component right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() * right.calculate();
    }
}

class TreeFactory {
    //    Component getCalculateTree (String expressionTo parse) { //parse
    static Component getCalculateTree() {
        Component plus1 = new OperationPlus(new Number(1), new Number(2));
        Component mult1 = new OperationMultiply(plus1, new Number(3));
        Component mult2 = new OperationMultiply(new Number(4), new Number(5));
        Component plus2 = new OperationPlus(mult1, mult2);

        return plus2;
    }
}

public class Main {
    public static void main(String[] args) {
        Component c = TreeFactory.getCalculateTree();
        System.out.println(c.calculate());
    }
}
