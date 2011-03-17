package com.plugtree.smartknowledgediscovery.client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;


public class QuestionDataSource implements DataSource<Question> {

	private List<Question> questions = new LinkedList<Question>();
	private List<QuestionTable> questionTableList = new LinkedList<QuestionTable>();
	private List<String> header;
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
		
		header = new ArrayList<String>();
		header.add("Id");
		header.add("Text");
		header.add("Notes");
	}

	@Override
    public List<Question> getList() {
		return this.questions;
	}

	private void setList(List<Question> questions) {
		this.questions = questions;
	}

	@Override
    public List<String> getTableHeader() {
		return this.header;
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
