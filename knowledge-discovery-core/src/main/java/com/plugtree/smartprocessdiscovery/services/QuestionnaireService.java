package com.plugtree.smartprocessdiscovery.services;

import java.util.Collection;

import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

public interface QuestionnaireService {

	public Collection<Questionnaire> findAll();

	public Long create(String name);

	public boolean remove(Long id);

	public boolean update(Long id, String name);

	public Questionnaire get(Long id);

	public boolean addCategory(Long id, Long catId);

	public boolean removeCategory(Long id, Long catId);

	public boolean addTag(Long id, String tag);

	public boolean removeTag(Long id, String tag);

	public boolean addQuestion(Long id, Long questionId);

	public boolean removeQuestion(Long id, Long questionId);

}