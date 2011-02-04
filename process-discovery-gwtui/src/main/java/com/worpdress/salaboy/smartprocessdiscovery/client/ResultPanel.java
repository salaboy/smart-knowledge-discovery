package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ResultPanel extends VLayout {
	
	HLayout taskCrudLayout = new HLayout();
	
	public ResultPanel() {
		
		DataSource humanTaskDataSource = new DataSource();
		DataSourceIntegerField idHumanTaskField = new DataSourceIntegerField("id", "Id", 4, true);
		idHumanTaskField.setPrimaryKey(true);
		DataSourceTextField humanTaskNameField = new DataSourceTextField("name", "Name", 40, true);
		humanTaskDataSource.setClientOnly(true);
		humanTaskDataSource.setFields(idHumanTaskField, humanTaskNameField);

		DataSource systemTaskDataSource = new DataSource();
		DataSourceIntegerField idSystemTaskField = new DataSourceIntegerField("id", "Id", 4, true);
		idSystemTaskField.setPrimaryKey(true);
		DataSourceTextField systemTaskNameField = new DataSourceTextField("name", "Name", 40, true);
		systemTaskDataSource.setClientOnly(true);
		systemTaskDataSource.setFields(idSystemTaskField, systemTaskNameField);
		
		DataSource resourceDataSource = new DataSource();
		DataSourceIntegerField idTaskField = new DataSourceIntegerField("id", "Id", 4, true);
		idTaskField.setPrimaryKey(true);
		DataSourceTextField resourceField = new DataSourceTextField("resource", "Resource", 50, true);
		resourceDataSource.setClientOnly(true);
		resourceDataSource.setFields(idTaskField, resourceField);
		
		CrudLayout humanTaskCrud = new CrudLayout(humanTaskDataSource, "Human Task");
		CrudLayout systemTaskCrud = new CrudLayout(systemTaskDataSource, "System Task");
		CrudLayout resourceCrud = new CrudLayout(resourceDataSource, "Resource");
		
		taskCrudLayout.setMembers(humanTaskCrud, systemTaskCrud);		
		taskCrudLayout.setMembersMargin(20);
		
		setMembers(taskCrudLayout, resourceCrud);
		setMembersMargin(10);
	}
}
