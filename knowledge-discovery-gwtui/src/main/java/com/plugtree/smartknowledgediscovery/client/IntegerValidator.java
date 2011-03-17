package com.plugtree.smartknowledgediscovery.client;

public class IntegerValidator implements Validator {

    private boolean obligatory;
    private int maxLenght;

    public IntegerValidator(boolean obligatory, int maxLenght) {
        this.obligatory = obligatory;
        this.maxLenght = maxLenght;
    }
    
    @Override
    public boolean isValid(String data) {

        if (obligatory && data.isEmpty()) {
            return false;
        }
        
        if (data.length() > maxLenght) {
            return false;
        }
        
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }
}
