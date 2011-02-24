package com.plugtree.smartprocessdiscovery.services;

import java.util.Collection;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public interface QuestionService {

	public Collection<Question> findAll();

	public Long create(String text, String notes);

	public boolean remove(Long id);

	public boolean update(Long id, String text, String notes);

	public Question get(Long id);

	public boolean addCategory(Long qId, Long catId);

	public boolean removeCategory(Long qId, Long catId);

	public boolean addTag(Long id, String tag);

	public boolean removeTag(Long id, String tag);

}