package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionTable extends FlexTable {

    private Label label = new Label("Questions");
    private QuestionDataSource dataSource;
    
    public QuestionTable(QuestionDataSource dataSource) {

        this.dataSource = dataSource;
        setUp(dataSource);
        dataSource.addTable(this);
    }
    
    public void refresh(List<Question> questionList) {
        
        for (int i = 2; i < getRowCount(); i ++) {
            removeRow(i);
        }

        int row = 2;

        for (final Question question : questionList) {

            Button removeButton = createRemoveButton(question.getId());
            Button editButton = createEditButton(question.getId());
            
            setText(row, 0, Long.toString(question.getId()));
            setText(row, 1, question.getText());
            setText(row, 2, question.getNotes());
            setWidget(row, 3, removeButton);
            setWidget(row, 4, editButton);
            
            getCellFormatter().addStyleName(row, 3, "buttonColumn");
            getCellFormatter().addStyleName(row, 4, "buttonColumn");
            
            row++;
        }
    }

    private void setUp(QuestionDataSource dataSource) {

        setWidget(0, 0, label);

        List<Field> fields = dataSource.getFields();

        getFlexCellFormatter().setColSpan(0, 0, fields.size() + 1);

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
        label.addStyleName("label");
    }

    private Button createRemoveButton(final Long id) {

        Button removeButton = new Button("x");

        removeButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                dataSource.remove(id);
            }
        });

        return removeButton;
    }

    private Button createEditButton(final Long id) {

        Button editButton = new Button("edit");

        editButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                //TODO: Show edit dialog.
                System.out.println("Editing!");
            }
        });

        return editButton;
    }
}
