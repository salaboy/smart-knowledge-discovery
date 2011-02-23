package com.wordpress.salaboy.smartknowledgediscovery.services;

import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

import java.util.List;

public interface QuestionService {

	void add(Question question);
	
	Question findById(Long id);

    List<Question> listAll();
    
    void removeById(Long id);
    
    void update(Question question);
}
