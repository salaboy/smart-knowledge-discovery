package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class QuestionRestDataSource extends RestDataSource {

	public QuestionRestDataSource() {
		// TODO Auto-generated constructor stub
		DataSourceTextField countryCode = new DataSourceTextField("countryCode", "Code");  
		
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
		
		setFetchDataURL("data/dataIntegration/xml/responses/country_fetch_rest.xml");  
		setAddDataURL("data/dataIntegration/xml/responses/country_add_rest.xml");  
		setUpdateDataURL("data/dataIntegration/xml/responses/country_update_rest.xml");  
		setRemoveDataURL("data/dataIntegration/xml/responses/country_remove_rest.xml");  
	}
}
