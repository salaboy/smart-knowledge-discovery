package com.plugtree.smartknowledgediscovery.client.datasources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.plugtree.smartknowledgediscovery.client.services.QuestionService;
import com.plugtree.smartknowledgediscovery.client.services.QuestionServiceAsync;
import com.plugtree.smartknowledgediscovery.client.utils.Field;
import com.plugtree.smartknowledgediscovery.client.utils.GenericAsyncCallback;
import com.plugtree.smartknowledgediscovery.client.utils.KeyField;
import com.plugtree.smartknowledgediscovery.client.utils.StringValidator;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;


public class QuestionDataSource extends GenericDataSource<Question> {

	private QuestionServiceAsync service;
    private static QuestionDataSource instance = null;	
	
    public static QuestionDataSource getInstance() {
        if(instance == null) {
           instance = new QuestionDataSource();
        }
        return instance;
     }
	
	private QuestionDataSource() {

	    service = GWT.create(QuestionService.class);
		((ServiceDefTarget)service).setServiceEntryPoint(GWT.getModuleBaseURL() + "question");

		fetch();
		
		Field textField = new Field("Text", new StringValidator(true, 200));
		Field notesField = new Field("Notes", new StringValidator(true, 200));
		Field idField = new KeyField("Id");

	    addField(idField);
		addField(textField);
		addField(notesField);
	}

	@Override
    public boolean fetch() {

	    service.fetch(new GenericAsyncCallback<Question>(getTableList()));

		return false; 
	}

    @Override
    public boolean fetchWithFilter(String filter) {

        service.fetchWithFilter(filter, new GenericAsyncCallback<Question>(getTableList()));

        return false;
    }

	@Override
    public boolean add(Question question) {

	    service.add(question, new GenericAsyncCallback<Question>(getTableList()));

		return false;
	}

	@Override
    public boolean remove(long id) {

	    service.remove(id, new GenericAsyncCallback<Question>(getTableList()));

		return false;
	}

	@Override
    public boolean update(Question question) {

	    service.update(question, new GenericAsyncCallback<Question>(getTableList()));

		return false;
	}
}
