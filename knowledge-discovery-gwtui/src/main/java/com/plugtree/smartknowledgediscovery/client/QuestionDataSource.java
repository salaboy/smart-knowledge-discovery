package com.plugtree.smartknowledgediscovery.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;


public class QuestionDataSource implements DataSource<Question> {

	private List<Question> questions;
	private List<String> header;
	private QuestionServiceAsync service;	

	public QuestionDataSource(){
		this.service = (QuestionServiceAsync) GWT.create(QuestionService.class);
		
		header = new ArrayList<String>();
		header.add("Id");
		header.add("Text");
		header.add("Notes");
		
		fetch();
		
		//ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		//serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL() + "userService");
		//MyUserCallback myUserCallback = new MyUserCallback(table);
		//service.getUserList(myUserCallback);

	}

	public List<Question> getList() {
		// TODO Auto-generated method stub
		return this.questions;
	}

	public List<String> getTableHeader() {
		// TODO Auto-generated method stub
		return this.header;
	}

	public boolean fetch() {
		// TODO Auto-generated method stub		
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
