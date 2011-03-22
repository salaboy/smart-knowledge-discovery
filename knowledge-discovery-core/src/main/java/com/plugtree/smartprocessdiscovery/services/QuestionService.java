package com.plugtree.smartprocessdiscovery.services;

import java.util.Collection;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public interface QuestionService {

	public Collection<Question> findAll();

	public Collection<Question> findAllWithFilter(String filter);

	public Long create(String text, String notes);

	public boolean remove(Long id) throws ServiceException;

	public boolean update(Long id, String text, String notes) throws ServiceException;

	public Question get(Long id);

	public boolean addCategory(Long qId, Long catId);

	public boolean removeCategory(Long qId, Long catId);

	public boolean addTag(Long id, String tag);

	public boolean removeTag(Long id, String tag);

}