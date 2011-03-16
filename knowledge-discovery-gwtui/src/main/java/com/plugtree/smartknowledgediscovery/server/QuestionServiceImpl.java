package com.plugtree.smartknowledgediscovery.server;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.QuestionService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

@SuppressWarnings("serial")
public class QuestionServiceImpl extends RemoteServiceServlet implements QuestionService {

	public List<Question> fetch() {

	    LinkedList<Question> list = new LinkedList<Question>();

	    Question question1 = new Question("what?");
	    Question question2 = new Question("how?");

	    list.add(question1);
	    list.add(question2);

	    return list;
	}

    public List<Question> add(Question question) {

        LinkedList<Question> list = new LinkedList<Question>();

        list.add(question);

        return list;
    }

    public List<Question> remove(Long questionId) {

        LinkedList<Question> list = new LinkedList<Question>();
        Question question = new Question("Removed?");

        list.add(question);

        return list;
    }

    public List<Question> update(Question question) {

        LinkedList<Question> list = new LinkedList<Question>();

        list.add(question);
 
        return list;
    }
}
