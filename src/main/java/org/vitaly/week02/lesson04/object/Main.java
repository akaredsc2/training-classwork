package org.vitaly.week02.lesson04.object;

/**
 * Created by root on 06.02.17.
 */
/*
equals
hashCode
finalize    not recommended
notify      |
notifyAll   | multithreading
wait        |
wait(time)  |
toString
clone
*/

/**
 * equals, hashCode
 * <assertion>
 * if equals is overloaded than hashCode should be overloaded too
 * if equals returns true than hashCodes must be equal(opposite may not be true)
 */

class A {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof A)) {
        /*if (other.getClass() == this.getClass())  should be used instead */
            return false;
        }
        return this.value == ((A) other).value;
    }

    public int hashCode() {
        /*return 0; formally correct*/
        return value;
    }

    @Override
    public String toString() {
        return "A{" +
                "value=" + value +
                '}';
    }
}

public class Main {
}
