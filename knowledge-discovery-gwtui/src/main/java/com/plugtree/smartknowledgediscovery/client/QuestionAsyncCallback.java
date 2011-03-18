package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionAsyncCallback implements AsyncCallback<List<Question>> {

    private List<QuestionTable> questionTableList;

    public QuestionAsyncCallback(List<QuestionTable> questionTableList) {
        this.questionTableList = questionTableList;
    }
    
    @Override
    public void onFailure(Throwable caught) {
        DialogBox dialogBox = new DialogBox(true);
        dialogBox.add(new Label("Warning, problem connecting to the server."));
        dialogBox.center();
        dialogBox.show();
    }

    @Override
    public void onSuccess(List<Question> resultList) {
        
        for (QuestionTable questionTable : questionTableList) {
            questionTable.refresh(resultList);
        }        
    }
}
