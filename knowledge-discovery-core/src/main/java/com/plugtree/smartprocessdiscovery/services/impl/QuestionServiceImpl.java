package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.Collection;
import java.util.Collections;

import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.QuestionService;

public class QuestionServiceImpl implements QuestionService {
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#findAll()
	 */
	@Override
	public Collection<Question> findAll() {
		// TODO buscar todos los cuestionarios
		
		Collection<Question> questions = Collections.emptyList();
		
		return questions;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#create(java.lang.String, java.lang.String)
	 */
	@Override
	public Long create(String text, String notes) {
		Question q = new Question();
		q.setText(text);
		q.setNotes(notes);
		
		// TODO persistir
		
		return q.getId();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#remove(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) {
		// TODO pedirle a la capa de persistencia que lo borre
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#update(java.lang.Long, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean update(Long id, String text, String notes) {
		// TODO buscarlo
		Question q = new Question();
		q.setText(text);
		q.setNotes(notes);
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#get(java.lang.Long)
	 */
	@Override
	public Question get(Long id) {
		// TODO buscarlo
		return new Question();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#addCategory(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean addCategory(Long qId, Long catId) {
		// TODO buscar pregunta
		Question question = new Question();
		// TODO buscar categoría
		Category category = new Category();
		
		if(question.getCategories().contains(category)) {
			return false;
		}
		
		question.addCategory(category);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#removeCategory(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean removeCategory(Long qId, Long catId) {
		// TODO buscar pregunta
		Question question = new Question();
		// TODO buscar categoría
		Category category = new Category();
		
		question.removeCategory(category);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#addTag(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean addTag(Long id, String tag) {
		// TODO buscar pregunta
		Question question = new Question();
		
		if(question.getTags().contains(tag)) {
			return false;
		}
		
		question.addTag(tag);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#removeTag(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean removeTag(Long id, String tag) {
		// TODO buscar pregunta
		Question question = new Question();
		
		question.removeTag(tag);
		
		// TODO persistir
		return true;
	}

}
