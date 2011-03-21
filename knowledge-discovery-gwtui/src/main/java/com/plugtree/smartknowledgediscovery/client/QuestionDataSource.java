package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;


public class QuestionDataSource extends GenericDataSource<Question> {

	private QuestionsServiceAsync service;
    private static QuestionDataSource instance = null;	
	
    public static QuestionDataSource getInstance() {
        if(instance == null) {
           instance = new QuestionDataSource();
        }
        return instance;
     }
	
	private QuestionDataSource() {

	    service = GWT.create(QuestionsService.class);
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

	    service.fetch(new QuestionAsyncCallback(getTableList()));

		return false; 
	}

	@Override
    public boolean add(Question question) {

	    service.add(question, new QuestionAsyncCallback(getTableList()));

		return false;
	}

	@Override
    public boolean remove(long id) {

	    service.remove(id, new QuestionAsyncCallback(getTableList()));

		return false;
	}

	@Override
    public boolean update(Question question) {

	    service.update(question, new QuestionAsyncCallback(getTableList()));

		return false;
	}
}
