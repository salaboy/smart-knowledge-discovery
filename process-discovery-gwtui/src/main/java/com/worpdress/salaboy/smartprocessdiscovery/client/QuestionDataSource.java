package com.worpdress.salaboy.smartprocessdiscovery.client;

import java.util.List;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionDataSource implements DataSource<Question> {

	private final List<Question> questions = null;
	private List<String> header = null;
	private static QuestionDataSource  instance;	
	
	public static QuestionDataSource getInstance() {

		if (instance == null) {
			instance = new QuestionDataSource(); 
		} 

		return instance;
	}
	
	@Override
	public List<String> getTableHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
