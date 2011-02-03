package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class HeaderArea extends HLayout {

	private Label title = new Label("Smart Process Discovery");
	//TODO: We should add an image as header.
	
	public HeaderArea() {
		
		title.setAlign(Alignment.CENTER);
		addMember(title);
	}
	
}
