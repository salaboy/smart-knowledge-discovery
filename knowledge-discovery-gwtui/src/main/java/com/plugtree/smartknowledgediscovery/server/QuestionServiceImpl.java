package com.plugtree.smartknowledgediscovery.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.GreetingService;
import com.plugtree.smartknowledgediscovery.client.QuestionService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionServiceImpl extends RemoteServiceServlet implements
QuestionService {

	public List<Question> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

}
