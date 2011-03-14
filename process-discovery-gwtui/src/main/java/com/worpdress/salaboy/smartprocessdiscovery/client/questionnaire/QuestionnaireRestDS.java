package com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire;


import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.data.events.DataArrivedEvent;
import com.smartgwt.client.data.events.DataArrivedHandler;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.worpdress.salaboy.smartprocessdiscovery.client.QuestionRestDS;

public class QuestionnaireRestDS extends RestDataSource {
	private static QuestionnaireRestDS  instance;
	
	public static QuestionnaireRestDS getInstance() {

		if (instance == null) {
			instance = new QuestionnaireRestDS(); 
		} 

		return instance;
	}

	private QuestionnaireRestDS() {

				
		setID("QuestionnaireRestDS");
		setDataFormat(DSDataFormat.XML);
		setRecordXPath("//questions");
		DataSourceIntegerField pkField = new DataSourceIntegerField("id","Id");  
		pkField.setHidden(false);  
		pkField.setPrimaryKey(false);
		pkField.setCanEdit(false);
		pkField.setValueXPath("../id");

		final DataSourceIntegerField questionIdField = new DataSourceIntegerField("questionId","Id Question");		
		questionIdField.setPrimaryKey(false);
		questionIdField.setValueXPath("id");				
		questionIdField.setMultiple(true);				
		
				
		DataSourceTextField questionField = new DataSourceTextField("questions", "Questions");		
		questionField.setValueXPath("text");
		questionField.setMultiple(true);
		
		
		DataSourceTextField nameField = new DataSourceTextField("name", "Name");
		nameField.setValueXPath("../name");

		setFields(pkField,nameField,questionIdField,questionField);

		OperationBinding fetch = new OperationBinding();  
		fetch.setOperationType(DSOperationType.FETCH);  
		fetch.setDataProtocol(DSProtocol.POSTMESSAGE);  

		OperationBinding add = new OperationBinding();  
		add.setOperationType(DSOperationType.ADD);  
		add.setDataProtocol(DSProtocol.POSTMESSAGE);

		OperationBinding update = new OperationBinding();  
		update.setOperationType(DSOperationType.UPDATE);  
		update.setDataProtocol(DSProtocol.POSTMESSAGE);

		OperationBinding remove = new OperationBinding();  
		remove.setOperationType(DSOperationType.REMOVE);  
		remove.setDataProtocol(DSProtocol.POSTMESSAGE);

		setOperationBindings(fetch, add, update, remove);  

		setFetchDataURL("dummyHttpServlet/questionnaire/get");
		setAddDataURL("dummyHttpServlet/questionnaire/add");  
		setUpdateDataURL("dummyHttpServlet/questionnaire/update");  
		setRemoveDataURL("dummyHttpServlet/questionnaire/remove");

	}

}