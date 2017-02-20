package org.vitaly.week04.lesson10.visitor;

/**
 * Created by vitaly on 20.02.17.
 */

//want to extend functionality. accept method is given
class Acceptor {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Acceptor acceptor);
}

class MyVisitor implements Visitor {
    @Override
    public void visit(Acceptor acceptor) {
        System.out.println("my visitor");
    }
}

public class Main {
    public static void main(String[] args) {
        Acceptor acceptor = new Acceptor();
        Visitor visitor = new MyVisitor();

        acceptor.accept(visitor);
    }
}
