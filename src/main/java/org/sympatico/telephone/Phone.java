package org.sympatico.telephone;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import static org.sympatico.telephone.PhoneState.*;

public class Phone {

    private static final Logger LOG = LoggerFactory.getLogger(Phone.class);
    private static final Pattern phonePattern =
            Pattern.compile("(?:(?:\\([0-9]{3}\\)\\s)|(?:[0-9]{3}-))?[0-9]{3}-[0-9]{4}");
    private static final AtomicBoolean connected = new AtomicBoolean(false);
    private static final Keypad keypad = new Keypad();

    static synchronized PhoneKey[] dial(String phoneNumber) throws NumberFormatException {
        if (connected.get())
            hangup();
        if (!phonePattern.matcher(phoneNumber).matches())
            throw new NumberFormatException("The provided string is not a valid phone number: " + phoneNumber);
        char[] numberArray = phoneNumber.replaceAll("[-()\\s]", "").toCharArray();
        final PhoneKey[] dialedNumber = new PhoneKey[numberArray.length];
        for (int i = 0; i < numberArray.length; i++) {
            dialedNumber[i] = (keypad.keyPress(numberArray[i] - '0'));
        }
        connected.set(true);
        return dialedNumber;
    }

    static synchronized void hangup() {
        if (connected.getAndSet(false)) {
            LOG.info("Hanging up current call...");
        }
    }

    static PhoneState getStatus() {
        return connected.get() ? CONNECTED: DISCONNECTED;
    }

    static PhoneState getDifficulty(PhoneKey[] dialedNumber) {
        for (int i = 1; i < dialedNumber.length; i++) {
            if (!dialedNumber[i].isNeighbor(dialedNumber[i - 1])) {
                return DIFFICULT;
            }
        }
        return EASY;
    }

}
