package org.sympatico.telephone;

import java.util.ArrayList;

public class PhoneKey {

    private final int digit;

    private final ArrayList<PhoneKey> neighbors = new ArrayList<PhoneKey>();

    PhoneKey(int digit) {
        this.digit = digit;
    }

    void addNeighbor(PhoneKey neighbor) {
        if (!neighbors.contains(neighbor))
            neighbors.add(neighbor);
    }

    boolean isNeighbor(PhoneKey phoneKey) {
        return neighbors.contains(phoneKey) || phoneKey.equals(this);
    }

    public String toString() {
        return String.valueOf(digit);
    }

    public int toInt() {
        return digit;
    }

    public boolean equals(PhoneKey phoneKey) {
        return phoneKey.toInt() == this.digit;
    }
}
