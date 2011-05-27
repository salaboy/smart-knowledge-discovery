package com.plugtree.smartknowledgediscovery.client.widgets;

import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.plugtree.smartknowledgediscovery.client.datasources.GenericDataSource;
import com.plugtree.smartknowledgediscovery.client.utils.Field;

abstract public class SmartTable<T> extends FlexTable {

    private Label tableTitle = new Label();
    private GenericDataSource<T> dataSource;
    
    public SmartTable(String title, GenericDataSource<T> dataSource) {

        this.dataSource = dataSource;

        tableTitle.setText(title);

        setUp(dataSource);
        dataSource.addTable(this);
    }
    
    public void removeRecords() {
        
        removeAllRows();
        setUp(dataSource);
    }
    
    public void refresh(List<T> list) {

        removeRecords();
        addRows(list);
    }

    public void setUp(GenericDataSource<T> dataSource) {

        setWidget(0, 0, tableTitle);

        List<Field> fields = dataSource.getFields();

        getFlexCellFormatter().setColSpan(0, 0, fields.size() + 2);

        setText(1, 0, "Select");
        
        int columNumber = 1;

        for (Field field : fields) {
            setText(1, columNumber, field.getName());
            columNumber++;
        }

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
