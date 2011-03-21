package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.user.client.ui.TextBox;

public class SmartTextBox extends TextBox {

    Field field;
    
    public SmartTextBox(Field field) {
        
        this.field = field;
        
        if (field.isKey()) {
            setEnabled(false);
        }
    }

    public boolean isContentValid() {
        
        boolean isContentValid = field.isValid(getText());

        if (isContentValid) {
            removeStyleName("invalidEntry");
        } else {
            addStyleName("invalidEntry");
        }

        return isContentValid;
    }

    public String getValidationError() {
        return field.getName() + ": " + field.getValidationError();
    }
}
