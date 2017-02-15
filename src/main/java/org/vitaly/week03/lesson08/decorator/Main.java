package org.vitaly.week03.lesson08.decorator;

/**
 * Created by vitaly on 15.02.17.
 */

abstract class Element {
    public abstract void show();
}

class Picture extends Element {
    @Override
    public void show() {
        System.out.println("picture");
    }
}

abstract class Decorator extends Element {
    Element element;

    public Decorator(Element element) {
        this.element = element;
    }
}

class Frame extends Decorator {
    public Frame(Element element) {
        super(element);
    }

    @Override
    public void show() {
        element.show();
        System.out.println("frame");
    }
}

class Pattern extends Decorator {
    public Pattern(Element element) {
        super(element);
    }

    @Override
    public void show() {
        element.show();
        System.out.println("pattern");
    }
}

public class Main {
    public static void main(String[] args) {
        Element picture = new Picture();
        picture.show();
        Element pictureInFrame = new Frame(picture);
        pictureInFrame.show();
        Element pictureInFrameWithPatter = new Pattern(pictureInFrame);
        pictureInFrameWithPatter.show();
    }
}
