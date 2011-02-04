package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

public class CategoryList extends ListGrid {

	public CategoryList(final ListGrid questionList) {

		DataSource categoryListDataSource = new DataSource();
		DataSourceTextField categoryNameField = new DataSourceTextField("itemCategoryName", "Filter Categories", 100, true);
		categoryNameField.setPrimaryKey(true);
		categoryListDataSource.addField(categoryNameField);
		categoryListDataSource.setClientOnly(true);
		categoryListDataSource.setTestData(new CategoryListRecord[] {new CategoryListRecord("Comida"), 
																	 new CategoryListRecord("Futbol"),
																	 new CategoryListRecord("IT")});

		setDataSource(categoryListDataSource);
		setWidth(200);
		setHeight(100);
		setShowAllRecords(true);
		setAutoFetchData(true);
		setSelectionAppearance(SelectionAppearance.CHECKBOX);
		
		addSelectionChangedHandler(new SelectionChangedHandler() {

			public void onSelectionChanged(SelectionEvent event) {

				ListGridRecord[] categories = getSelection();

				String[] filterCategories = new String[categories.length];

				for(int i = 0; i < categories.length; i++) {
					filterCategories[i] = categories[i].getAttribute("itemCategoryName");
				}

				AdvancedCriteria criteria = new AdvancedCriteria("itemCategory", OperatorId.NOT_IN_SET, filterCategories);

				questionList.filterData(criteria);
			}
		});
	}
}
