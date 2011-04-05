package com.plugtree.smartknowledgediscovery.client.utils;

public abstract class Validator {

    private boolean obligatory;
    private int maxLenght;
    private String validationError;

    public Validator(boolean obligatory, int maxLenght) {
        this.obligatory = obligatory;
        this.maxLenght = maxLenght;
    }
    
    public boolean isObligatorinessValid(String data) {

        if (obligatory && data.isEmpty()) {
            setValidationError("Obligatory field.");
            return false;
        }

        return true;
    }
    
    public boolean isLenghtValid(String data) {

        if (data.length() > maxLenght) {
            setValidationError("Lenght should be lower than " + maxLenght + " caracters.");
            return false;
        }

        return true;
    }   

    public String getValidationError() {
        return validationError;
    }

    public void setValidationError(String validationError) {
        this.validationError = validationError;
    }

    public abstract boolean isValid(String data);
}
