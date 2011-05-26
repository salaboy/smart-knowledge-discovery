package com.plugtree.smartknowledgediscovery.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

public interface QuestionnaireService extends RemoteService {
		
    List<Questionnaire> fetch();

    List<Questionnaire> fetchWithFilter(String filter);

    List<Questionnaire> add(Questionnaire questionnaire);
    
    List<Questionnaire> remove(Long questionId) ;
    
    List<Questionnaire> update(Questionnaire questionnaire) ;
 

}
