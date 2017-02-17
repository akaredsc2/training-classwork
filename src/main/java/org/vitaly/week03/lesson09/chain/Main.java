package org.vitaly.week03.lesson09.chain;

/**
 * Created by vitaly on 17.02.17.
 */

abstract class Handler {
    Handler handler;

    public Handler(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void execute(String command);
}

class MyHandler1 extends Handler {
    public MyHandler1(Handler handler) {
        super(handler);
    }

    @Override
    public void execute(String command) {
        if ("command1".equals(command)) {
            System.out.println(command);
        } else {
            handler.execute(command);
        }
    }
}

class MyHandler2 extends Handler {
    public MyHandler2(Handler handler) {
        super(handler);
    }

    @Override
    public void execute(String command) {
        if ("command2".equals(command)) {
            System.out.println(command);
        } else {
            handler.execute(command);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Handler handler2 = new MyHandler2(null);
        Handler handler1 = new MyHandler1(handler2);

        handler1.execute("command1");
        handler1.execute("command2");
//        handler1.execute("command3");
    }
}
