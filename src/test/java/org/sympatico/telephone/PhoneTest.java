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
        String difficultNumber = "293-5712";
        testResult = Phone.dial(difficultNumber);
        Assert.assertEquals("Phone number is easy: " + difficultNumber, DIFFICULT, Phone.getDifficulty(testResult));
        String difficultLongNumber = "(555) 245-0242";
        testResult = Phone.dial(difficultLongNumber);
        Assert.assertEquals("Phone number is easy: " + difficultLongNumber, DIFFICULT, Phone.getDifficulty(testResult));
        String easyLongNumber = "(555) 245-1242";
        testResult = Phone.dial(easyLongNumber);
        Assert.assertEquals("Phone number is not easy: " + easyLongNumber, EASY, Phone.getDifficulty(testResult));
        String easyNumber = "123-5478";
        testResult = Phone.dial(easyNumber);
        Assert.assertEquals("Phone number is not easy: " + easyNumber, EASY, Phone.getDifficulty(testResult));
        try {
            String invalidNumber = "a12-45~6";
            Phone.dial(invalidNumber);
        } catch (Exception e) {
            Assert.assertEquals("Unexpected exception type: " + e.getClass(), NumberFormatException.class, e.getClass());
        }


    }
}
