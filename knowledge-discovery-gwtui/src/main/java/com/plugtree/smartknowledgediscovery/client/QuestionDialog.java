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
    private Button addButton = new Button("Add");
    private Button cancelButton = new Button("Cancel");

    public QuestionDialog(final QuestionDataSource questionDataSource) {

        final QuestionForm questionForm = new QuestionForm(questionDataSource);

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        addButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                
                if (questionForm.isDataValid()) {
                    Question question = questionForm.getQuestion();
                    questionDataSource.add(question);
                    hide();
                } else {
                    //TODO: Highlight wrong fields with css and add a error dialog.
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
        addButton.addStyleName("button");
        cancelButton.addStyleName("button");

        center();
    }
}
