package com.worpdress.salaboy.smartprocessdiscovery.client;

import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TablePopUp extends PopupPanel {
	
	private Button addButton = new Button("Add");
	private Button cancelButton = new Button("Cancel");
	private HashMap<String, TextBox> hash = new HashMap<String, TextBox>();
	private VerticalPanel popUpContent = new VerticalPanel();
	
	public TablePopUp(String[] fields) {
		
		for (int i = 0; i < fields.length; i++) {
			
			HorizontalPanel hPanel = new HorizontalPanel();
			
			TextBox textBox = new TextBox();
			Label label = new Label(fields[i]);
			
			hPanel.add(label);
			hPanel.add(textBox);	
			
			hash.put(fields[i], textBox);
			
			popUpContent.add(hPanel);
		}
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(cancelButton);
		
		popUpContent.add(buttonPanel);
		
		add(popUpContent);
		
		cancelButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				hide();
			}
		});
	}

}
