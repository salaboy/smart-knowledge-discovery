package com.plugtree.smartprocessdiscovery.services;

import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

public interface QuestionnaireRepository extends Repository<Questionnaire> {

	public boolean addCategory(Long id, Long catId);

	public boolean removeCategory(Long id, Long catId);

	public boolean addTag(Long id, String tag);

	public boolean removeTag(Long id, String tag);

	public boolean addQuestion(Long id, Long questionId);

	public boolean removeQuestion(Long id, Long questionId);

}