package org.vitaly.week03.lesson09.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 17.02.17.
 */

class MyCharacter {
    char b;

    public MyCharacter(char b) {
        this.b = b;
    }

    public char getB() {
        return b;
    }

    public void setB(char b) {
        this.b = b;
    }
}

class WordFactory {
    private static WordFactory instance = new WordFactory();

    public static WordFactory getInstance() {
        return instance;
    }

    public List<MyCharacter> getWord(String word) {
        List<MyCharacter> myCharacters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            MyCharacter symbol = null;
            for (MyCharacter mc : myCharacters) {
                if (mc.getB() == c) {
                    symbol = mc;
                    break;
                }
            }
            if (symbol == null) {
                myCharacters.add(new MyCharacter(c));
            } else {
                myCharacters.add(symbol);
            }
        }
        return myCharacters;
    }
}

public class Main {
}
