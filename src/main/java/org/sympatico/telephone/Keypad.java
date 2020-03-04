package org.sympatico.telephone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Keypad {
    private static final Logger LOG = LoggerFactory.getLogger(Keypad.class);

    private static final Map<Integer, PhoneKey> keypadDigits = new HashMap<>();

    public Keypad() {
        keypadDigits.put(0, new PhoneKey("0".toCharArray()));
        keypadDigits.put(1, new PhoneKey("1".toCharArray()));
        keypadDigits.put(2, new PhoneKey("2AaBbCc".toCharArray()));
        keypadDigits.put(3, new PhoneKey("3DdEeFf".toCharArray()));
        keypadDigits.put(4, new PhoneKey("4GgHhIi".toCharArray()));
        keypadDigits.put(5, new PhoneKey("5JjKkLl".toCharArray()));
        keypadDigits.put(6, new PhoneKey("6MmNnOo".toCharArray()));
        keypadDigits.put(7, new PhoneKey("7PpQqRrSs".toCharArray()));
        keypadDigits.put(8, new PhoneKey("8TtUuVv".toCharArray()));
        keypadDigits.put(9, new PhoneKey("9WwXxYyZz".toCharArray()));
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

    public PhoneKey charToDigit(char c) {
        for (int i = 0; i < keypadDigits.size(); i++) {
            for (char letter: keypadDigits.get(i).letters()) {
                if (c == letter) {
                    return keypadDigits.get(i);
                }
            }
        }
        return null;
    }
}