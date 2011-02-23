package com.plugtree.smartprocessdiscovery.services;

import java.util.Collection;
import java.util.Collections;

import com.worpdress.salaboy.smartprocessdiscovery.model.common.Category;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Questionnaire;

public class QuestionnaireService {
	
	public Collection<Questionnaire> findAll() {
		// TODO buscar todos los cuestionarios
		
		Collection<Questionnaire> questionnaires = Collections.emptyList();
		
		return questionnaires;
	}
	
	public Long create(String name) {
		Questionnaire questionnaire = new Questionnaire(name);
		
		// TODO persistir
		
		return questionnaire.getId();
	}
	
	public boolean remove(Long id) {
		// TODO pedirle a la capa de persistencia que lo borre
		return true;
	}
	
	public boolean update(Long id, String name) {
		// TODO buscarlo
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setName(name);
		// TODO persistir
		return true;
	}
	
	public Questionnaire get(Long id) {
		// TODO buscarlo
		return new Questionnaire();
	}
	
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
	
	public boolean removeCategory(Long id, Long catId) {
		// TODO buscar pregunta
		Questionnaire questionnaire = new Questionnaire();
		// TODO buscar categoría
		Category category = new Category();
		
		questionnaire.removeCategory(category);
		
		// TODO persistir
		
		return true;
	}
	
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
	
	public boolean removeTag(Long id, String tag) {
		// TODO buscar cuestionario
		Questionnaire questionnaire = new Questionnaire();
		
		questionnaire.removeTag(tag);
		
		// TODO persistir
		return true;
	}
	
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
