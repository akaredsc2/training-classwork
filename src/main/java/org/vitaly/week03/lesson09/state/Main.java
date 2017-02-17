package org.vitaly.week03.lesson09.state;

/**
 * Created by vitaly on 17.02.17.
 */

class TV {
    State state;

    public TV() {
        this.state = new SwitchOff(this);
    }

    public void switchOn() {
        state.switchOn();
    }

    public void switchOff() {
        state.switchOff();
    }

    public void changeChannel(String channel) {
        state.changeChannel(channel);
    }
}

abstract class State {
    TV tv;

    public State(TV tv) {
        this.tv = tv;
    }

    void switchOn() {
        System.out.println("can't switch on the TV");
    }

    void switchOff() {
        System.out.println("can't switch off the TV");
    }

    void changeChannel(String channel) {
        System.out.println("can't change channel");
    }
}

class SwitchOn extends State {
    public SwitchOn(TV tv) {
        super(tv);
    }

    @Override
    void switchOff() {
        tv.state = new SwitchOff(tv);
    }

    @Override
    void changeChannel(String channel) {
        System.out.println("changing channel to " + channel);
    }
}

class SwitchOff extends State {
    public SwitchOff(TV tv) {
        super(tv);
    }

    @Override
    void switchOn() {
        tv.state = new SwitchOn(tv);
    }
}

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        tv.switchOff();
        tv.changeChannel("1 + 4");
        tv.switchOn();
        tv.changeChannel("8 + 8");
        tv.switchOff();
    }
}
