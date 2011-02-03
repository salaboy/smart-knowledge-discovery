package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class LocalDataSource extends DataSource {

	public LocalDataSource() {
		
		setID("supplyItemLocalDS");
		
		DataSourceIntegerField pkField = new DataSourceIntegerField("itemID");  
		pkField.setHidden(true);  
		pkField.setPrimaryKey(true);
		
		DataSourceTextField questionField = new DataSourceTextField("itemQuestion", "Question", 300, true);
		DataSourceTextField descriptionField = new DataSourceTextField("itemDescription", "Description", 2000, true);
		DataSourceTextField categoryField = new DataSourceTextField("itemCategory", "Category", 30, true);
        
		setFields(pkField, questionField, descriptionField, categoryField);
		
		setClientOnly(true);
		
		QuestionListRecord[] questions = new QuestionListRecord[]{new QuestionListRecord(1, "Ugis o La Continental?", "Pregunta decisiva", "Comida"),
																  new QuestionListRecord(2, "River o Boca?", "Obvio que river.", "Futbol")};
		
        setTestData(questions);  
	}	
}
