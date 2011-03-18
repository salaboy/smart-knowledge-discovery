package com.plugtree.smartknowledgediscovery.server;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.QuestionService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

@SuppressWarnings("serial")
public class QuestionServiceImpl extends RemoteServiceServlet implements QuestionService {

    private LinkedList<Question> questionList = new LinkedList<Question>();

    public QuestionServiceImpl() {

        Question question1 = new Question("what?");
        question1.setId(new Long(1));
        question1.setNotes("Amazing");

        Question question2 = new Question("how?");
        question2.setId(new Long(2));
        question2.setNotes("Impressive");

        questionList.add(question1);
        questionList.add(question2);
    }

	@Override
    public List<Question> fetch() {

	    return questionList;
	}

    @Override
    public List<Question> add(Question question) {

        questionList.add(question);

        return questionList;
    }

    @Override
    public List<Question> remove(Long questionId) {

        final Iterator<Question> it = questionList.iterator();

        while (it.hasNext()) {

            if (it.next().getId().equals(questionId)) {
                it.remove();
                break;
            }
        }

        return questionList;
    }

    @Override
    public List<Question> update(Question question) {

        final Iterator<Question> it = questionList.iterator();

        while (it.hasNext()) {

            if (it.next().getId().equals(question.getId())) {
                it.next().setText(question.getText());
                it.next().setNotes(question.getNotes());
                break;
            }
        }
 
        return questionList;
    }
}
