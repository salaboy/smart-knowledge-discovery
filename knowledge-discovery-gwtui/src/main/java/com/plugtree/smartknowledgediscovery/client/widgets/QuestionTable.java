package com.plugtree.smartknowledgediscovery.client.widgets;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.plugtree.smartknowledgediscovery.client.datasources.QuestionDataSource;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionTable extends SmartTable<Question> {

    public QuestionTable() {

        super("Questions", QuestionDataSource.getInstance());
    }

    public void addRows(List<Question> questionList) {

        int row = 2;

        for (final Question question : questionList) {

            Button removeButton = createRemoveButton(question.getId());
            Button editButton = createEditButton(question);

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

    private Button createRemoveButton(final Long id) {

        Button removeButton = new Button("x");

        removeButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                QuestionDataSource.getInstance().remove(id);
            }
        });

        return removeButton;
    }

    private Button createEditButton(final Question question) {

        Button editButton = new Button("edit");

        editButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                new QuestionDialog(question).show();
            }
        });

        return editButton;
    }
}
