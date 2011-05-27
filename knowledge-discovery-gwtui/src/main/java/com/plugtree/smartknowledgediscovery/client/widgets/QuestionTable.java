package com.plugtree.smartknowledgediscovery.client.widgets;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.plugtree.smartknowledgediscovery.client.datasources.QuestionDataSource;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionTable extends SmartTable<Question> {

	private LinkedList<CheckBox> checkBoxList = new LinkedList<CheckBox>();
	
    public QuestionTable() {

        super("Questions", QuestionDataSource.getInstance());
    }
    
    public void addRows(List<Question> questionList) {

    	checkBoxList.clear();
    	
        int row = 2;

        for (final Question question : questionList) {
        	
        	CheckBox checkbox = new CheckBox();
        	checkBoxList.add(checkbox);
        	
        	final int rowSelected = row; 
        	
        	checkbox.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					CheckBox checkbox = (CheckBox)event.getSource();
					if (checkbox.getValue()) {
						getRowFormatter().addStyleName(rowSelected, "selected");
					} else {
						getRowFormatter().removeStyleName(rowSelected, "selected");
					}
				}
			});
        	
        	setWidget(row, 0, checkbox);        	
        	setText(row, 1, String.valueOf(question.getId()));
            setText(row, 2, question.getText());
            setText(row, 3, question.getNotes());
            
            row++;
        }
    }
    
    public List<Long> getSelectedIds() {
    	
    	List<Long> selectedIdList = new LinkedList<Long>();
    	
    	int row = 2;
    	for(CheckBox checkbox : checkBoxList) {
    		
    		if (checkbox.getValue()) {
    			selectedIdList.add(Long.valueOf(getText(row, 1)));
    		}
    		
    		row++;
    	}
    	
    	return selectedIdList;
    }
}
