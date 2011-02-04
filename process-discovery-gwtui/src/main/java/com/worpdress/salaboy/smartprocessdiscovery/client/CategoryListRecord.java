package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CategoryListRecord extends ListGridRecord {

	public CategoryListRecord(String categoryName) {
		setItemCategoryName(categoryName);
	}

	public void setItemCategoryName(String categoryName) {
		setAttribute("itemCategoryName", categoryName);
	}
	
	public String getItemCategoryName() {
		return getAttribute("itemCategoryName");
	}
}
