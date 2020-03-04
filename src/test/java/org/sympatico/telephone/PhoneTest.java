package org.sympatico.telephone;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.sympatico.telephone.PhoneState.DIFFICULT;
import static org.sympatico.telephone.PhoneState.EASY;

public class PhoneTest {

    @Test
    public void dialPhoneNumber() {
        Logger.getGlobal().setLevel(Level.FINEST);
        Phone phone = new Phone();
        PhoneKey[] testResult;
        String difficultNumber = "(800) 555-1212";
        testResult = Phone.dial(difficultNumber);
        Assert.assertEquals("Phone number is easy: " + difficultNumber, DIFFICULT, Phone.getDifficulty(testResult));
        String difficultLongNumber = "(800) 555-BEEF";
        testResult = Phone.dial(difficultLongNumber);
        Assert.assertEquals("Phone number is easy: " + difficultLongNumber, DIFFICULT, Phone.getDifficulty(testResult));
        String easyLongNumber = "(800) 555-2333";
        testResult = Phone.dial(easyLongNumber);
        Assert.assertEquals("Phone number is not easy: " + easyLongNumber, DIFFICULT, Phone.getDifficulty(testResult));
        String easy = "(223) 555-BEEF";
        testResult = Phone.dial(easy);
        Assert.assertEquals("Phone number is not easy: " + easyLongNumber, EASY, Phone.getDifficulty(testResult));
        try {
            String invalidNumber = "a12-45~6";
            Phone.dial(invalidNumber);
        } catch (Exception e) {
            Assert.assertEquals("Unexpected exception type: " + e.getClass(), NumberFormatException.class, e.getClass());
        }


    }
}
