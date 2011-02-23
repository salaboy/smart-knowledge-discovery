package com.worpdress.salaboy.smartprocessdiscovery.services;

import java.util.Collection;
import java.util.Collections;

import com.worpdress.salaboy.smartprocessdiscovery.model.common.Category;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

public class QuestionService {
	
	public Collection<Question> findAll() {
		// TODO buscar todos los cuestionarios
		
		Collection<Question> questions = Collections.emptyList();
		
		return questions;
	}
	
	public Long create(String text, String notes) {
		Question q = new Question();
		q.setText(text);
		q.setNotes(notes);
		
		// TODO persistir
		
		return q.getId();
	}
	
	public boolean remove(Long id) {
		// TODO pedirle a la capa de persistencia que lo borre
		return true;
	}
	
	public boolean update(Long id, String text, String notes) {
		// TODO buscarlo
		Question q = new Question();
		q.setText(text);
		q.setNotes(notes);
		// TODO persistir
		return true;
	}
	
	public Question get(Long id) {
		// TODO buscarlo
		return new Question();
	}
	
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
	
	public boolean removeCategory(Long qId, Long catId) {
		// TODO buscar pregunta
		Question question = new Question();
		// TODO buscar categoría
		Category category = new Category();
		
		question.removeCategory(category);
		
		// TODO persistir
		return true;
	}
	
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
	
	public boolean removeTag(Long id, String tag) {
		// TODO buscar pregunta
		Question question = new Question();
		
		question.removeTag(tag);
		
		// TODO persistir
		return true;
	}

}
