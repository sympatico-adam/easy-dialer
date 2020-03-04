package org.sympatico.telephone;

import java.util.*;

public class Keypad {

    private static final Map<Integer, PhoneKey> keypadDigits = new HashMap<>();

    public Keypad() {
        for (int digit = 0; digit <= 9; digit ++) {
            keypadDigits.put(digit, new PhoneKey(digit));
        }
        for (int key = 7; key <= 9; key++) {
            keypadDigits.get(key).addNeighbor(keypadDigits.get(0));
            keypadDigits.get(0).addNeighbor(keypadDigits.get(key));
        }
        for (int key = 1; key <= 4; key += 3) {
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key + 3));
            keypadDigits.get(key + 3).addNeighbor(keypadDigits.get(key));
            keypadDigits.get(key + 2).addNeighbor(keypadDigits.get(key + 5));
            keypadDigits.get(key + 5).addNeighbor(keypadDigits.get(key + 2));
        }
        for (int key = 1; key <= 4; key += 3) {
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key + 4));
            keypadDigits.get(key + 4).addNeighbor(keypadDigits.get(key));
            keypadDigits.get(key + 2).addNeighbor(keypadDigits.get(key + 4));
            keypadDigits.get(key + 4).addNeighbor(keypadDigits.get(key + 2));
        }
        for (int key = 8; key >= 5; key -= 3) {
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key - 4));
            keypadDigits.get(key - 4).addNeighbor(keypadDigits.get(key));
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key - 2));
            keypadDigits.get(key - 2).addNeighbor(keypadDigits.get(key));
        }
        for (int key = 2; key <= 5; key += 3) {
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key + 4));
            keypadDigits.get(key + 4).addNeighbor(keypadDigits.get(key));
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key + 2));
            keypadDigits.get(key + 2).addNeighbor(keypadDigits.get(key));
        }
        for (int key = 2; key <= 8; key += 3) {
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key - 1));
            keypadDigits.get(key - 1).addNeighbor(keypadDigits.get(key));
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key + 1));
            keypadDigits.get(key + 1).addNeighbor(keypadDigits.get(key));
        }
        for (int key = 2; key <= 5; key += 3) {
            keypadDigits.get(key).addNeighbor(keypadDigits.get(key + 3));
        }
    }

    public PhoneKey keyPress(int digit) {
        return keypadDigits.get(digit);
    }
}
