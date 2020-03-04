package org.sympatico.telephone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneKey {

    private final ArrayList<PhoneKey> neighbors = new ArrayList<>();

    private final char[] chars;

    PhoneKey(char[] chars) {
        this.chars = chars;
    }

    void addNeighbor(PhoneKey neighbor) {
        if (!neighbors.contains(neighbor))
            neighbors.add(neighbor);
    }

    boolean isNeighbor(PhoneKey phoneKey) {
        return neighbors.contains(phoneKey) || phoneKey.equals(this);
    }

    public char[] letters() {
        return chars;
    }

    public String toString() {
        return Arrays.toString(chars);
    }

    public int toInt() {
        return chars[0];
    }

    public boolean equals(PhoneKey phoneKey) {
        return chars[0] == phoneKey.toInt();
    }
}