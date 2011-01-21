package com.example.discovery.client;

import java.util.LinkedList;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CheckBoxList extends VerticalPanel {
		
	public CheckBoxList(String listName, LinkedList<String> itemList) {
				
		add(new Label(listName));
		
		for (String item : itemList){
			
			add(new CheckBox(item));			
		}
	}
	
}
