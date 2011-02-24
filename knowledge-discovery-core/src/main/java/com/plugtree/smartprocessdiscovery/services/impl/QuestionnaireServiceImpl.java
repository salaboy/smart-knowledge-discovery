package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.Collection;
import java.util.Collections;

import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;
import com.plugtree.smartprocessdiscovery.services.QuestionnaireService;

public class QuestionnaireServiceImpl implements QuestionnaireService {
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#findAll()
	 */
	@Override
	public Collection<Questionnaire> findAll() {
		// TODO buscar todos los cuestionarios
		
		Collection<Questionnaire> questionnaires = Collections.emptyList();
		
		return questionnaires;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#create(java.lang.String)
	 */
	@Override
	public Long create(String name) {
		Questionnaire questionnaire = new Questionnaire(name);
		
		// TODO persistir
		
		return questionnaire.getId();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#remove(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) {
		// TODO pedirle a la capa de persistencia que lo borre
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#update(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean update(Long id, String name) {
		// TODO buscarlo
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setName(name);
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#get(java.lang.Long)
	 */
	@Override
	public Questionnaire get(Long id) {
		// TODO buscarlo
		return new Questionnaire();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#addCategory(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean addCategory(Long id, Long catId) {
		// TODO buscar pregunta
		Questionnaire questionnaire = new Questionnaire();
		// TODO buscar categoría
		Category category = new Category();
		
		if(questionnaire.getCategories().contains(category)) {
			return false;
		}
		
		questionnaire.addCategory(category);
		
		// TODO persistir
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#removeCategory(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean removeCategory(Long id, Long catId) {
		// TODO buscar pregunta
		Questionnaire questionnaire = new Questionnaire();
		// TODO buscar categoría
		Category category = new Category();
		
		questionnaire.removeCategory(category);
		
		// TODO persistir
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#addTag(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean addTag(Long id, String tag) {
		// TODO buscar cuestionario
		Questionnaire questionnaire = new Questionnaire();
		
		if(questionnaire.getTags().contains(tag)) {
			return false;
		}
		
		questionnaire.addTag(tag);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#removeTag(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean removeTag(Long id, String tag) {
		// TODO buscar cuestionario
		Questionnaire questionnaire = new Questionnaire();
		
		questionnaire.removeTag(tag);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#addQuestion(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean addQuestion(Long id, Long questionId) {
		// TODO buscar cuestionario
		Questionnaire questionnaire = new Questionnaire();
		// TODO buscar pregunta
		Question question = new Question();
		
		if(questionnaire.getQuestions().contains(question)) {
			return false;
		}
		
		questionnaire.addQuestion(question);
		
		// TODO persistir
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#removeQuestion(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean removeQuestion(Long id, Long questionId) {
		// TODO buscar cuestionario
		Questionnaire questionnaire = new Questionnaire();
		// TODO buscar pregunta
		Question question = new Question();
		
		questionnaire.removeQuestion(question);
		
		// TODO persistir
		
		return true;
	}

}
