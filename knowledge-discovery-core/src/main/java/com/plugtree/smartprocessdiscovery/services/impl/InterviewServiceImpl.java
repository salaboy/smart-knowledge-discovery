package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.Collection;
import java.util.Date;

import com.plugtree.smartprocessdiscovery.dao.AnswerDao;
import com.plugtree.smartprocessdiscovery.dao.AnsweredQuestionnaireDao;
import com.plugtree.smartprocessdiscovery.dao.InterviewDao;
import com.plugtree.smartprocessdiscovery.dao.PersonDao;
import com.plugtree.smartprocessdiscovery.dao.QuestionDao;
import com.plugtree.smartprocessdiscovery.dao.QuestionnaireDao;
import com.plugtree.smartprocessdiscovery.model.process.Interview;
import com.plugtree.smartprocessdiscovery.model.process.Person;
import com.plugtree.smartprocessdiscovery.model.questionaire.Answer;
import com.plugtree.smartprocessdiscovery.model.questionaire.AnsweredQuestionnaire;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;
import com.plugtree.smartprocessdiscovery.services.InterviewService;
import com.plugtree.smartprocessdiscovery.services.ServiceException;

public class InterviewServiceImpl implements InterviewService {
	
	private InterviewDao interviewDao;
	
	private QuestionnaireDao questionnaireDao;
	
	private QuestionDao questionDao;
	
	private AnsweredQuestionnaireDao answeredQuestionnaireDao;
	
	private PersonDao personDao;
	
	private AnswerDao answerDao;
	
	public InterviewServiceImpl() {

	}
	
	public void setInterviewDao(InterviewDao interviewDao) {
		this.interviewDao = interviewDao;
	}

	public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
		this.questionnaireDao = questionnaireDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public void setAnsweredQuestionnaireDao(
			AnsweredQuestionnaireDao answeredQuestionnaireDao) {
		this.answeredQuestionnaireDao = answeredQuestionnaireDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#findAll()
	 */
	@Override
	public Collection<Interview> findAll() {
		return interviewDao.listAll();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#create(java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Long create(String description, Long questionnaireId, Long personId) throws ServiceException {
		Interview interview = new Interview();
		interview.setDescription(description);
		
		Questionnaire questionnaire = questionnaireDao.findById(questionnaireId);
		if(questionnaire==null) {
			throw new ServiceException("Questionnaire doesn't exist");
		}
		
		AnsweredQuestionnaire answeredQuestionnaire = new AnsweredQuestionnaire(questionnaire);
		interview.setQuestionnaire(answeredQuestionnaire);
		
		Person person = personDao.findById(personId);
		if(person==null) {
			throw new ServiceException("Person doesn't exist");
		}
		interview.setPerson(person);
		
		answeredQuestionnaireDao.save(answeredQuestionnaire);
		interviewDao.save(interview);
		
		return interview.getId();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#remove(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) throws ServiceException {
		Interview interview = interviewDao.findById(id);
		if(interview==null) {
			throw new ServiceException("Interview doesn't exist");
		}
		
		interviewDao.remove(interview);
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#update(java.lang.Long, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean update(Long id, String description, Date dueDate, Date startDate, Date endDate, Long questionnaireId, Long personId) throws ServiceException {
		AnsweredQuestionnaire newQuestionnaire = null;
		AnsweredQuestionnaire oldQuestionnaire = null;
		
		Interview interview = interviewDao.findById(id);
		if(interview==null) {
			throw new ServiceException("Interview doesn't exist");
		}
		interview.setDescription(description);
		interview.setDueDate(dueDate);
		interview.setStartDate(startDate);
		interview.setEndDate(endDate);
		
		Person person = personDao.findById(personId);
		if(person==null) {
			throw new ServiceException("Person doesn't exist");
		}
		interview.setPerson(person);
		
		Questionnaire questionnaire = questionnaireDao.findById(questionnaireId);
		if(questionnaire==null) {
			throw new ServiceException("Questionnaire doesn't exist");
		}
		
		if(!questionnaire.equals(interview.getQuestionnaire())) {
			oldQuestionnaire = interview.getQuestionnaire();
			newQuestionnaire = new AnsweredQuestionnaire(questionnaire);
			
			interview.setQuestionnaire(newQuestionnaire);
			
			answeredQuestionnaireDao.remove(oldQuestionnaire);
		}
			
		interviewDao.update(interview);
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#get(java.lang.Long)
	 */
	@Override
	public Interview get(Long id) {
		return interviewDao.findById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#addAnswer(java.lang.Long, java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean addAnswer(Long id, Long questionId, String text) throws ServiceException {
		Interview interview = interviewDao.findById(id);
		if(interview==null) {
			throw new ServiceException("Interview doesn't exist");
		}
		
		Question question = questionDao.findById(questionId);
		if(question==null) {
			throw new ServiceException("Question doesn't exist");
		}
		
		Answer answer = new Answer();
		answer.setQuestion(question);
		answer.setText(text);
		
		interview.getQuestionnaire().addAnswer(answer);
		
		answerDao.save(answer);
		
		answeredQuestionnaireDao.update(interview.getQuestionnaire());
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.InterviewService#removeAnswer(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean removeAnswer(Long id, Long questionId) throws ServiceException {
		Interview interview = interviewDao.findById(id);
		if(interview==null) {
			throw new ServiceException("Interview doesn't exist");
		}
		
		Question question = questionDao.findById(questionId);
		if(question==null) {
			throw new ServiceException("Question doesn't exist");
		}
		
		Answer answer = interview.getQuestionnaire().getAnswer(question);
		if(answer==null) {
			throw new ServiceException("The question doesn't have an answer");
		}
		
		interview.getQuestionnaire().removeAnswer(question);
		
		answerDao.remove(answer);
		
		answeredQuestionnaireDao.update(interview.getQuestionnaire());
		
		return true;
	}

}
