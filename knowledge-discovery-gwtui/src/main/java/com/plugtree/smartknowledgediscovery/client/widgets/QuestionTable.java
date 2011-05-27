package com.plugtree.smartknowledgediscovery.client.widgets;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.plugtree.smartknowledgediscovery.client.datasources.QuestionDataSource;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionTable extends SmartTable<Question> {

	private LinkedList<Long> checkedIds = new LinkedList<Long>();
	
    public QuestionTable() {

        super("Questions", QuestionDataSource.getInstance());
    }
    
    public void addRows(List<Question> questionList) {

        int row = 2;

        for (final Question question : questionList) {
        	
        	CheckBox checkbox = new CheckBox();
        	
        	checkbox.addClickHandler(new ClickHandler() {
        		
        		public void onClick(ClickEvent event) {
        			
        			boolean boxIsChecked = ((CheckBox) event.getSource()).getValue();
        			Long id = question.getId();
        			
        			if (boxIsChecked) {
        				checkedIds.add(id);
        			} else {
        				checkedIds.remove(id);
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
    	return checkedIds;
    }
}
