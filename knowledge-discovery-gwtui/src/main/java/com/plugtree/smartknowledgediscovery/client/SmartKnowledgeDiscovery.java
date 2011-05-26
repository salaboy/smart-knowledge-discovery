package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.plugtree.smartknowledgediscovery.client.widgets.CategoryPanel;
import com.plugtree.smartknowledgediscovery.client.widgets.QuestionPanel;
import com.plugtree.smartknowledgediscovery.client.widgets.QuestionnairePanel;

public class SmartKnowledgeDiscovery implements EntryPoint {

	private TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
	
	private QuestionPanel questionPanel = new QuestionPanel();
	private CategoryPanel categoryPanel = new CategoryPanel();
	private QuestionnairePanel questionnairePanel = new QuestionnairePanel();

	private final String WIDTH_TAB = "720px";
	private final String HEIGHT_TAB = "420px";
	private final String WIDTH_INNER_PANEL = "700px";
	private final String HEIGHT_INNER_PANEL = "400px";
	
	@Override
	public void onModuleLoad() {

		tabPanel.add(questionPanel,"Question");
		tabPanel.add(questionnairePanel,"Questionnaire");
		tabPanel.add(new HTML("Interview"),"Interview");
		tabPanel.add(categoryPanel, "Categories");
		
		tabPanel.setSize(WIDTH_TAB, HEIGHT_TAB);
		questionPanel.setSize(WIDTH_INNER_PANEL, HEIGHT_INNER_PANEL);
		categoryPanel.setSize(WIDTH_INNER_PANEL, HEIGHT_INNER_PANEL);
		questionnairePanel.setSize(WIDTH_INNER_PANEL, HEIGHT_INNER_PANEL);
						
		RootPanel.get("mainPanel").add(tabPanel);
	
		addStyle();
	}

	private void addStyle() {
		tabPanel.addStyleName("gwt-TabLayoutPanel");	
	}
}
