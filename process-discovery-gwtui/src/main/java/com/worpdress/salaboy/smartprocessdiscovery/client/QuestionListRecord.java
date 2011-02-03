package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class QuestionListRecord extends ListGridRecord {

	public QuestionListRecord(int id, String question, String description, String category) {
		
		setItemId(id);
		setItemQuestion(question);
		setItemDescription(description);
		setItemCategory(category);		
	}

	private void setItemId(int id) {
		setAttribute("itemId", id);	
	}
	
	public void setItemQuestion(String question) {
		setAttribute("itemQuestion", question);	
	}

	public void setItemDescription(String description) {
		setAttribute("itemDescription", description);		
	}

	public void setItemCategory(String category) {
		setAttribute("itemCategory", category);
	}
	
	public String getItemQuestion() {
		return getAttribute("itemQuestion");
	}
	
	public String getItemDescription() {
		return getAttribute("itemDescription");
	}

	public String getItemCategory() {
		return getAttribute("itemCategory");
	}
	
	public int getItemId() {
		return getAttributeAsInt("itemId");
	}
}
