package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.smartgwt.client.widgets.layout.VLayout;

public class SmartProcessDiscovery implements EntryPoint {
	
	private VLayout northLayout = new VLayout();
	private VLayout southLayout = new VLayout();
	private VLayout mainLayout = new VLayout();
	
	public void onModuleLoad() {
		
		Window.enableScrolling(false);
		Window.setMargin("0px");
		
		northLayout.setHeight("150px");
		northLayout.setMembers(new HeaderArea(),  new Menu(southLayout));
	
		southLayout.addMember(new CrudQuestions());
		
		mainLayout.setMembers(northLayout, southLayout);
		
		RootLayoutPanel.get().add(mainLayout);
	}
}
