package com.plugtree.smartknowledgediscovery.client.widgets;

import java.util.HashMap;
import java.util.LinkedList;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.plugtree.smartknowledgediscovery.client.datasources.GenericDataSource;
import com.plugtree.smartknowledgediscovery.client.utils.Field;

public class Form<T> extends Grid {
    
    protected HashMap<String, SmartTextBox> data = new HashMap<String, SmartTextBox>();
    private LinkedList<String> errors = new LinkedList<String>(); 

    public void setUp(GenericDataSource<T> dataSource, boolean isEditForm) {

        resize(dataSource.getFields().size(), 2);

        int row = 0;

        for (Field field : dataSource.getFields()) {

            if (field.isKey() &&  !isEditForm) {
                continue;
            }

            SmartTextBox textBox = new SmartTextBox(field);

            setWidget(row, 0, new Label(field.getName()));
            setWidget(row, 1, textBox);

            data.put(field.getName(), textBox);

            row++;
        }
    }
    
    public boolean isDataValid() {

        boolean valid = true;
        errors.clear();

        for (String fieldName : data.keySet()) {

            SmartTextBox textBox = data.get(fieldName);

            if (!textBox.isContentValid()) {
                errors.add(textBox.getValidationError());
                valid = false;
            }
        }

        return valid;
    }

    public LinkedList<String> getValidationErrors() {
        return errors;
    }
}
