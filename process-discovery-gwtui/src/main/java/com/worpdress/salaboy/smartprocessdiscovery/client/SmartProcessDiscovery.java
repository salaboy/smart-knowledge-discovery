package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public class SmartProcessDiscovery implements EntryPoint
{
	public void onModuleLoad()
	{
		RootPanel.get("topMenu").add(new TopMenu());
		RootPanel.get().add(new CrudQuestions());
		
		IButton button = new IButton("Hello world");
		button.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				SC.say("Hello World from SmartGWT");
			}
		});
		
		button.draw();
	}
}
