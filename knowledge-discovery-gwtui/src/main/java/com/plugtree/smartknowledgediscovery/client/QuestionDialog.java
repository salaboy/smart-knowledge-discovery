package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class QuestionDialog extends PopupPanel {

    private VerticalPanel popupContent = new VerticalPanel();

    private HorizontalPanel buttonPanel = new HorizontalPanel();
    private Button addButton = new Button("Add");
    private Button cancelButton = new Button("Cancel");    

    public QuestionDialog(QuestionDataSource questionDataSource) {

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        cancelButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                hide(); 
            }
        });

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
