package com.plugtree.smartknowledgediscovery.client;

import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class QuestionPanel extends VerticalPanel  {
	private Button addButton = new Button("Add");
	private VerticalPanel panel = new VerticalPanel();
	public QuestionPanel(){
		QuestionTable questionTable = new QuestionTable();
		add(questionTable);
		add(addButton);

		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				QuestionDialog questionDialog = new QuestionDialog(null);
				questionDialog.show();
			}
		});
		
		addStyle();
				
	}
	private void addStyle() {
		addButton.addStyleName("button");

	}
	
	
}
