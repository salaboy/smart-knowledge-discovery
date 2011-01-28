package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class SmartTable extends FlexTable {
	
	public SmartTable(String tableName, String[] columnsName) {
		
		setWidget(0, 0, new Label(tableName));
		getFlexCellFormatter().setColSpan(0, 0, columnsName.length);
		
		for (int column = 0; column < columnsName.length; column++)
		{
			setText(1, column, columnsName[column]);
		}
		
		addStyle();
	}
	
	private void addStyle() {
		
		getRowFormatter().addStyleName(0, "listHeader");
		getRowFormatter().addStyleName(1, "listHeader");
		addStyleName("list");
	}
}
