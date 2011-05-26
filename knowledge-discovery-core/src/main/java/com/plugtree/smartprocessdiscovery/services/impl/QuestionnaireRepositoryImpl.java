package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.LinkedList;
import java.util.List;

import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;
import com.plugtree.smartprocessdiscovery.services.QuestionnaireRepository;
import com.plugtree.smartprocessdiscovery.services.RepositoryException;

public class QuestionnaireRepositoryImpl implements QuestionnaireRepository {
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#findAll()
	 */
	@Override
	public List<Questionnaire> findAll() {

		List<Questionnaire> questionnaires = new LinkedList<Questionnaire>();
		
		return questionnaires;
	}
	
	@Override
	public List<Questionnaire> findAllWithFilter(String filter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#create(java.lang.String)
	 */
	@Override
	public Long add(Questionnaire questionnaire) {
		//TODO: Persistir!
		
		return questionnaire.getId();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#remove(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) throws RepositoryException {
		
		//TODO: improve...
		if(id == null) {
			throw new RepositoryException("Questionnaire doesn't exist");
		}

		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionnaireService#update(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean update(Questionnaire questionnaire) throws RepositoryException {

		if(questionnaire == null) {
			throw new RepositoryException("Questionnaire doesn't exist");
		}
		
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
