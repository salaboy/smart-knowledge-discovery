package com.plugtree.smartknowledgediscovery.client.utils;

public class StringValidator extends Validator {

    public StringValidator(boolean obligatory, int maxLenght) {
        super(obligatory, maxLenght);
    }

    @Override
    public boolean isValid(String data) {

        if (isObligatorinessValid(data) && isLenghtValid(data)) {
            return true;
        }

        return false;
    }
}
