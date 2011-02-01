package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class SmartProcessDiscovery implements EntryPoint {

	
	public void onModuleLoad() {
	
		RootPanel.get("topMenu").add(new TopMenu());
		RootPanel.get().add(new CrudQuestions());
	}
}