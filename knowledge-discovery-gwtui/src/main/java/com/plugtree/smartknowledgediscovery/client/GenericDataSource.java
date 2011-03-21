package com.plugtree.smartknowledgediscovery.client;

import java.util.LinkedList;
import java.util.List;

abstract public class GenericDataSource<T> implements DataSource<T> {

    private List<Field> fieldList = new LinkedList<Field>();
    private List<SmartTable<T>> tableList = new LinkedList<SmartTable<T>>();
    
    public List<Field> getFields() {
        return fieldList;
    }

    public void addField(Field field) {
        fieldList.add(field);
    }
    
    public void addTable(SmartTable<T> table) {
        tableList.add(table);
    }

    public List<SmartTable<T>> getTableList() {
        return tableList;
    }
}
