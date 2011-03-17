package com.plugtree.smartknowledgediscovery.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;


public class QuestionDataSource implements DataSource<Question> {

	private List<Question> questions;
	private List<String> header;
	private ServiceDefTarget serviceDef;	

	public QuestionDataSource(){
		QuestionServiceAsync service = (QuestionServiceAsync) GWT.create(QuestionService.class);
		this.serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL() + "questionService");

		
		header = new ArrayList<String>();
		header.add("Id");
		header.add("Text");
		header.add("Notes");

		fetch();
		

	}

	public List<Question> getList() {
		// TODO Auto-generated method stub
		return this.questions;
	}

	private void setList(List<Question> questions) {
		this.questions = questions;
	}

	public List<String> getTableHeader() {
		// TODO Auto-generated method stub
		return this.header;
	}

	public boolean fetch() {
		// TODO Auto-generated method stub
		((QuestionServiceAsync) serviceDef).fetch(new AsyncCallback<List<Question>>() {

			public void onSuccess(List<Question> arg0) {
				// TODO Auto-generated method stub
				setList(arg0); 				
			}

			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				getList().add(new Question("BLEH"));
			}
		});
		return false; 
	}


	public boolean add(Question element) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Question element) {
		// TODO Auto-generated method stub
		return false;
	}


}
