package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.ServiceException;

public interface QuestionsService extends RemoteService {
		
    List<Question> fetch();
		
    List<Question> add(Question question);
    
    List<Question> remove(Long questionId) ;
    
    List<Question> update(Question question) ;
}
