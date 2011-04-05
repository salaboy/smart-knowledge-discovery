package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.plugtree.smartknowledgediscovery.client.widgets.CategoryPanel;
import com.plugtree.smartknowledgediscovery.client.widgets.QuestionPanel;
import com.plugtree.smartknowledgediscovery.client.widgets.QuestionnairePanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartKnowledgeDiscovery implements EntryPoint {


	TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
	QuestionPanel questionPanel = new QuestionPanel();
	CategoryPanel categoryPanel = new CategoryPanel();
	QuestionnairePanel questionnairePanel = new QuestionnairePanel();
	DockLayoutPanel mainDockPanel = new DockLayoutPanel(Unit.EM);

	@Override
	public void onModuleLoad() {
		tabPanel.add(questionPanel,"Question");
		tabPanel.add(questionnairePanel,"Questionnaire");
		tabPanel.add(new HTML("Interview"),"Interview");
		tabPanel.add(categoryPanel, "Categories");
		tabPanel.setSize("500px", "250px");
		mainDockPanel.add(tabPanel);
		mainDockPanel.setSize("500px", "250px");
						
		RootPanel.get("mainPanel").add(mainDockPanel);
	
		addStyle();
		
	}
	private void addStyle() {
		mainDockPanel.addStyleName("dockPanel");	
		mainDockPanel.addStyleName("gwt-TabLayoutPanel");	
	}

	

}
