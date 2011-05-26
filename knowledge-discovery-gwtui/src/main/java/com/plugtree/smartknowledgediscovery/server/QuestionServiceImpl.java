package com.plugtree.smartknowledgediscovery.server;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.services.QuestionService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.RepositoryException;
import com.plugtree.smartprocessdiscovery.services.impl.QuestionRepositoryImpl;

@SuppressWarnings("serial")
public class QuestionServiceImpl extends RemoteServiceServlet implements QuestionService {

	private QuestionRepositoryImpl questionRepository;  

	public QuestionServiceImpl() throws RepositoryException {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
		questionRepository = (QuestionRepositoryImpl) applicationContext.getBean("questionService");
	}

	@Override
	public List<Question> fetch() {

		return questionRepository.findAll();
	}

	@Override
	public List<Question> fetchWithFilter(String filter) {

		return questionRepository.findAllWithFilter(filter);
	}

	@Override
	public List<Question> add(Question question) {

		questionRepository.add(question);

		return questionRepository.findAll();
	}

	@Override
	public List<Question> remove(Long questionId) {

		try {
			questionRepository.remove(questionId);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

		return questionRepository.findAll();
	}

	@Override
	public List<Question> update(Question question){

		try {
			questionRepository.update(question);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

		return questionRepository.findAll();
	}
}
