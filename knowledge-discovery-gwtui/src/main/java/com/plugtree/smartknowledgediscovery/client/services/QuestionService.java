package com.plugtree.smartknowledgediscovery.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public interface QuestionService extends RemoteService {
		
    List<Question> fetch();

    List<Question> fetchWithFilter(String filter);

    List<Question> add(Question question);
    
    List<Question> remove(Long questionId) ;
    
    List<Question> update(Question question) ;
    
    Question get(Long questionId);
}
