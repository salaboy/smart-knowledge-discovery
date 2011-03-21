package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

abstract public class SmartTable<T> extends FlexTable {

    Label tableTitle = new Label();
    
    public SmartTable(String title) {
        tableTitle.setText(title);
    }
    
    public void removeRecords() {
        
        for (int i = 2; i < getRowCount(); i++) {
            removeRow(i);
        }
    }
    
    public void refresh(List<T> list) {

        removeRecords();
        addRows(list);
    }

    public void setUp(QuestionDataSource dataSource) {

        setWidget(0, 0, tableTitle);

        List<Field> fields = dataSource.getFields();

        getFlexCellFormatter().setColSpan(0, 0, fields.size() + 2);

        int columNumber = 0;

        for (Field field : fields) {
            setText(1, columNumber, field.getName());
            columNumber++;
        }

        setText(1, columNumber, "Remove");
        setText(1, columNumber + 1, "Edit");

        addStyle();
    }
    
    private void addStyle() {

        getRowFormatter().addStyleName(0, "listHeader");
        getRowFormatter().addStyleName(1, "listHeader");
        addStyleName("list");
        tableTitle.addStyleName("label");
    }

    abstract void addRows(List<T> list);
}
