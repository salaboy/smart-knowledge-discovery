package com.plugtree.smartknowledgediscovery.client.utils;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.plugtree.smartknowledgediscovery.client.datasources.QuestionDataSource;

public class FilterBox extends HorizontalPanel {

    private Button filterButton = new Button("Filter");
    private TextBox textBox = new TextBox();
    
    public FilterBox(final QuestionDataSource dataSource) {

        add(textBox);
        add(filterButton);

        setSpacing(10);
        
        filterButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                filter(dataSource);
            }
        });
        
        // Not working due to a gwt bug.
        textBox.addKeyPressHandler(new KeyPressHandler() {
            
            @Override
            public void onKeyPress(KeyPressEvent event) {

                if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                    filter(dataSource);
                }
            }
        });
    }

    private void filter(QuestionDataSource dataSource) {

        if (textBox.getText().isEmpty()) {
            dataSource.fetch();
        } else {
            dataSource.fetchWithFilter(textBox.getText());
        }
    }
}
