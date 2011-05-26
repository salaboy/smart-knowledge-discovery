package com.plugtree.smartknowledgediscovery.server;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.services.QuestionsService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.ServiceException;
import com.plugtree.smartprocessdiscovery.services.impl.QuestionRepositoryImpl;

@SuppressWarnings("serial")
public class QuestionsServiceImpl extends RemoteServiceServlet implements QuestionsService {

    private QuestionRepositoryImpl questionRepository;  
  
	public QuestionsServiceImpl() throws ServiceException {

    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
    	System.out.println(applicationContext.toString());
    	System.out.println(applicationContext.containsBean("questionService"));
    	questionRepository = (QuestionRepositoryImpl) applicationContext.getBean("questionService");

    	System.out.println(questionRepository.toString());

        Question question1 = new Question("what?");
        question1.setId(new Long(1));
        question1.setNotes("Amazing");

        Question question2 = new Question("how?");
        question2.setId(new Long(2));
        question2.setNotes("Impressive");

        questionRepository.create(question1.getText(),question1.getNotes());
        questionRepository.create(question2.getText(),question2.getNotes());
    }

	@Override
    public List<Question> fetch() {

	    return (List<Question>) questionRepository.findAll();
	}

    @Override
    public List<Question> fetchWithFilter(String filter) {

        return (List<Question>) questionRepository.findAllWithFilter(filter);
    }

    @Override
    public List<Question> add(Question question) {

        questionRepository.create(question.getText(), question.getNotes());

        return (List<Question>) questionRepository.findAll();
    }

    @Override
    public List<Question> remove(Long questionId) {

    	try {
			questionRepository.remove(questionId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return (List<Question>) questionRepository.findAll();
    }

    @Override
    public List<Question> update(Question question){

       try {
		questionRepository.update(question.getId(), question.getText(), question.getNotes());
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
       return (List<Question>) questionRepository.findAll();
    }
}
