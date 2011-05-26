package com.plugtree.smartprocessdiscovery.services;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public interface QuestionRepository extends Repository<Question>{

	public boolean addCategory(Long questionId, Long categoryId);

	public boolean removeCategory(Long questionId, Long categoryId);

	public boolean addTag(String tagName);

	public boolean removeTag(Long tagId);
}