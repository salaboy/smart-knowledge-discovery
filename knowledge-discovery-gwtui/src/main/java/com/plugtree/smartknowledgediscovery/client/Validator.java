package com.plugtree.smartknowledgediscovery.client;

public abstract class Validator {

    private boolean obligatory;
    private int maxLenght;

    public Validator(boolean obligatory, int maxLenght) {
        this.obligatory = obligatory;
        this.maxLenght = maxLenght;
    }
    
    public boolean isObligatorinessValid(String data) {

        if (obligatory && data.isEmpty()) {
            return false;
        }

        return true;
    }
    
    public boolean isLenghtValid(String data) {

        if (data.length() > maxLenght) {
            return false;
        }

        return true;
    }   

    public abstract boolean isValid(String data);
}
