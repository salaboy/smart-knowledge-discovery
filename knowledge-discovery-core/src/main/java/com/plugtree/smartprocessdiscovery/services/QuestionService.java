package com.plugtree.smartprocessdiscovery.services;

import java.util.List;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public interface QuestionService {

	void add(Question question);
	
	Question findById(Long id);

    List<Question> listAll();
    
    void removeById(Long id);
    
    void update(Question question);
}
