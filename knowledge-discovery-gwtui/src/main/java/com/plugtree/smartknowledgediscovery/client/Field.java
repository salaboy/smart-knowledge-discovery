package com.plugtree.smartknowledgediscovery.client;


public class Field {
  
    private String name;
    private Validator validator;

    public Field(String name, Validator validator) {
        this.name = name;
        this.validator = validator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isValid(String data)
    {
        if (!validator.isValid(data)) {
            return false;   
        }

        return true;
    }

    public String getValidationError() {
        return validator.getValidationError();
    }
}
