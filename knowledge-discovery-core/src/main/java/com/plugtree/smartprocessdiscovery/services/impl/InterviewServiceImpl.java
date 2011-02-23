package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import com.plugtree.smartprocessdiscovery.model.process.Interview;
import com.plugtree.smartprocessdiscovery.model.process.Person;
import com.plugtree.smartprocessdiscovery.model.questionaire.Answer;
import com.plugtree.smartprocessdiscovery.model.questionaire.AnsweredQuestionnaire;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;
import com.plugtree.smartprocessdiscovery.services.InterviewService;

public class InterviewServiceImpl implements InterviewService {
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#findAll()
	 */
	@Override
	public Collection<Interview> findAll() {
		// TODO buscar todos los cuestionarios
		
		Collection<Interview> interviews = Collections.emptyList();
		
		return interviews;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#create(java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Long create(String description, Long questionnaireId, Long personId) {
		Interview interview = new Interview();
		interview.setDescription(description);
		
		// TODO buscar cuestionario
		Questionnaire questionnaire = new Questionnaire();
		AnsweredQuestionnaire answeredQuestionnaire = new AnsweredQuestionnaire(questionnaire);
		interview.setQuestionnaire(answeredQuestionnaire);
		
		// TODO buscar persona
		Person person = new Person();
		interview.setPerson(person);
		
		// TODO persistir
		
		return interview.getId();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#remove(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) {
		// TODO pedirle a la capa de persistencia que lo borre
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#update(java.lang.Long, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean update(Long id, String description, Date dueDate, Date startDate, Date endDate, Long questionnaireId, Long personId) {
		// TODO buscarlo
		Interview interview = new Interview();
		interview.setDescription(description);
		interview.setDueDate(dueDate);
		interview.setStartDate(startDate);
		interview.setEndDate(endDate);
		
		// TODO buscar persona
		Person person = new Person();
		interview.setPerson(person);
		
		// TODO buscar cuestionario
		Questionnaire questionnaire = new Questionnaire();
		AnsweredQuestionnaire answeredQuestionnaire = new AnsweredQuestionnaire(questionnaire);
		
		// TODO borrar interview.getQuestionnaire()
		
		interview.setQuestionnaire(answeredQuestionnaire);
			
		// TODO persistir
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#get(java.lang.Long)
	 */
	@Override
	public Interview get(Long id) {
		// TODO buscarlo
		return new Interview();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#addAnswer(java.lang.Long, java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean addAnswer(Long id, Long questionId, String text) {
		// TODO buscar entrevista
		Interview interview = new Interview();
		
		// TODO buscar pregunta
		Question question = new Question();
		
		Answer answer = new Answer();
		answer.setQuestion(question);
		answer.setText(text);
		
		// TODO persistir answer
		
		interview.getQuestionnaire().addAnswer(answer);
		
		// TODO persistir interview
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#removeAnswer(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean removeAnswer(Long id, Long questionId) {
		// TODO buscar entrevista
		Interview interview = new Interview();
		
		// TODO buscar pregunta
		Question question = new Question();
		
		interview.getQuestionnaire().removeAnswer(question);
		
		// TODO despersistir respuesta?
		
		// TODO persistir
		
		return true;
	}

}
