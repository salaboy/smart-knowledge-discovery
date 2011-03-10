package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.layout.VLayout;

public class CrudCategories extends VLayout {

    public CrudCategories() {
        DataSource categoryDataSource = new CategoryRestDS();

        CrudLayout crudCategories = new CrudLayout(categoryDataSource, "Category");

        addMember(crudCategories);
    }
}
