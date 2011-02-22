package com.wordpress.salaboy.smartknowledgediscovery.services;

import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

public interface QuestionService {

	void add(Question question);
	
	Question findById(Long id);
	
}
