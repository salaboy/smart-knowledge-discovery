package com.plugtree.smartknowledgediscovery.server;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.services.QuestionnaireService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;
import com.plugtree.smartprocessdiscovery.services.RepositoryException;
import com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireRepositoryImpl;

@SuppressWarnings("serial")
public class QuestionnaireServiceImpl extends RemoteServiceServlet implements QuestionnaireService {

	private QuestionnaireRepositoryImpl questionnaireRepository;
	
	public QuestionnaireServiceImpl(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
		questionnaireRepository = (QuestionnaireRepositoryImpl)applicationContext.getBean("questionnaireService");	
	}

	@Override
	public List<Questionnaire> fetch() {
		return questionnaireRepository.findAll();
	}

	@Override
	public List<Questionnaire> fetchWithFilter(String filter) {
		return questionnaireRepository.findAllWithFilter(filter);
	}

	@Override
	public List<Questionnaire> add(Questionnaire questionnaire) {
		questionnaireRepository.add(questionnaire);

		return questionnaireRepository.findAll();
	}

	@Override
	public List<Questionnaire> remove(Long questionnaireId) {
		
		try {
			questionnaireRepository.remove(questionnaireId);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

		return questionnaireRepository.findAll();
	}

	@Override
	public List<Questionnaire> update(Questionnaire questionnaire) {

		try {
			questionnaireRepository.update(questionnaire);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

		return questionnaireRepository.findAll();
	}
}
