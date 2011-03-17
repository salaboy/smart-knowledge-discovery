package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionTable extends FlexTable {

    private Label label = new Label("Questions");

    public QuestionTable(QuestionDataSource dataSource) {
          
        setUp(dataSource);
        dataSource.addTable(this);
    }
    
    public void refresh(List<Question> questionList) {
        
        for (int i = 2; i < getRowCount(); i ++) {
            removeRow(i);
        }

        int row = 2;

        for (Question question : questionList) {

            setText(row, 0, Long.toString(question.getId()));
            setText(row, 1, question.getText());
            setText(row, 2, question.getNotes());
            row++;
        }
    }
    
    private void setUp(QuestionDataSource dataSource) {
        
        setWidget(0, 0, label);
       
        List<String> tableHeaders = dataSource.getTableHeader();
        
        getFlexCellFormatter().setColSpan(0, 0, tableHeaders.size());
        
        int columNumber = 0;
        
        for (String header : tableHeaders) {
            setText(1, columNumber, header);
            columNumber++;
        }

        addStyle();
    }
    
    private void addStyle() {

        getRowFormatter().addStyleName(0, "listHeader");
        getRowFormatter().addStyleName(1, "listHeader");
        addStyleName("list");
        label.addStyleName("label");
    }
}
