package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionDialog extends PopupPanel {

    private VerticalPanel popupContent = new VerticalPanel();

    private HorizontalPanel buttonPanel = new HorizontalPanel();
    private Button addEditButton = new Button();
    private Button cancelButton = new Button("Cancel");

    public QuestionDialog(final Question question) {

        final QuestionDataSource questionDataSource = QuestionDataSource.getInstance();
        final QuestionForm questionForm = new QuestionForm(question);

        if (question == null) {
            addEditButton.setText("Add");
        } else {
            addEditButton.setText("Edit");
        }

        buttonPanel.add(addEditButton);
        buttonPanel.add(cancelButton);

        addEditButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                if (questionForm.isDataValid()) {
                    Question newQuestion = questionForm.getQuestion();

                    if (question == null) {
                        questionDataSource.add(newQuestion);
                    } else {
                        questionDataSource.update(newQuestion);
                    }

                    hide();
                } else {
                    //Add an error dialog.
                    for( String error : questionForm.getValidationErrors()) {
                        System.out.println(error);
                    }
                }
            }
        });

        cancelButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                hide(); 
            }
        });

        popupContent.add(questionForm);
        popupContent.add(buttonPanel);

        setWidget(popupContent);

        addStyle();
    }

    private void addStyle() {
        addEditButton.addStyleName("button");
        cancelButton.addStyleName("button");

        center();
    }
}
