package com.plugtree.smartknowledgediscovery.client.utils;

public class IntegerValidator extends Validator {

    public IntegerValidator(boolean obligatory, int maxLenght) {
        super(obligatory, maxLenght);
    }

    @Override
    public boolean isValid(String data) {

        if (!isLenghtValid(data) || !isObligatorinessValid(data)) {
            return false;
        }

        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            setValidationError("Valid number expected.");
            return false;
        }

        return true;
    }
}
