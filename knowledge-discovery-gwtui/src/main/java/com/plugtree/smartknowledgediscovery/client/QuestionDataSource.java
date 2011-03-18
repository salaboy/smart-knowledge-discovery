package com.plugtree.smartknowledgediscovery.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;


public class QuestionDataSource implements DataSource<Question> {

	private List<QuestionTable> questionTableList = new LinkedList<QuestionTable>();
	private List<Field> fieldList = new LinkedList<Field>();
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
		((ServiceDefTarget)service).setServiceEntryPoint(GWT.getModuleBaseURL() + "questionService");

		fetch();
		
		Field textField = new Field("Text", new StringValidator(true, 200));
		Field notesField = new Field("Notes", new StringValidator(true, 200));
		Field idField = new Field("Id", new IntegerValidator(true, 50));

	    fieldList.add(idField);
		fieldList.add(textField);
		fieldList.add(notesField);
	}

	@Override
    public List<Field> getFields() {
		return fieldList;
	}

	@Override
    public boolean fetch() {

	    service.fetch(new QuestionAsyncCallback(questionTableList));

		return false; 
	}

	@Override
    public boolean add(Question question) {

	    service.add(question, new QuestionAsyncCallback(questionTableList));

		return false;
	}

	@Override
    public boolean remove(long id) {

	    service.remove(id, new QuestionAsyncCallback(questionTableList));

		return false;
	}

	@Override
    public boolean update(Question question) {

	    service.update(question, new QuestionAsyncCallback(questionTableList));

		return false;
	}

    public void addTable(QuestionTable questionTable) {
        questionTableList.add(questionTable);
    }
}
