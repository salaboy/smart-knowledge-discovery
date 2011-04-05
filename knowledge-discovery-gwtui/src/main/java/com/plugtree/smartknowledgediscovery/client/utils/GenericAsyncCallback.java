package com.plugtree.smartknowledgediscovery.client.utils;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.plugtree.smartknowledgediscovery.client.widgets.SmartTable;

public class GenericAsyncCallback<T> implements AsyncCallback<List<T>> {

    private List<SmartTable<T>> tableList;

    public GenericAsyncCallback(List<SmartTable<T>> tableList) {
        this.tableList = tableList;
    }
    
    @Override
    public void onFailure(Throwable caught) {
        DialogBox dialogBox = new DialogBox(true);
        dialogBox.add(new Label("Warning, problem connecting to the server."));
        dialogBox.center();
        dialogBox.show();
    }

    @Override
    public void onSuccess(List<T> resultList) {
        
        for (SmartTable<T> table : tableList) {
            table.refresh(resultList);
        }        
    }
}
