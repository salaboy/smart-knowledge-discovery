package com.plugtree.smartknowledgediscovery.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.services.QuestionsService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

@SuppressWarnings("serial")
public class QuestionnairesServiceImpl extends RemoteServiceServlet implements QuestionsService{

	public QuestionnairesServiceImpl(){
		System.out.println("Questionnaire Service UP");		
	}
	
	@Override
	public List<Question> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> fetchWithFilter(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> add(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> remove(Long questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> update(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

}
