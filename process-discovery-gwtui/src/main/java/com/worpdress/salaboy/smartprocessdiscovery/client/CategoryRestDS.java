package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class CategoryRestDS extends RestDataSource {

    public CategoryRestDS() {
        
        setID("CategoryRestDS");

        DataSourceIntegerField pkField = new DataSourceIntegerField("id");  
        pkField.setHidden(false);  
        pkField.setPrimaryKey(true);
        pkField.setCanEdit(false);

        DataSourceTextField questionField = new DataSourceTextField("name", "Name", 40, true);
        DataSourceIntegerField rankField = new DataSourceIntegerField("rank", "Rank", 3, true);
        
        setFields(pkField, questionField, rankField);
        
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

        setFetchDataURL("dummyHttpServlet/category/get");
        setAddDataURL("dummyHttpServlet/category/add");  
        setUpdateDataURL("dummyHttpServlet/category/update");  
        setRemoveDataURL("dummyHttpServlet/category/remove");
    }
}
