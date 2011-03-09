package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

@XmlRootElement(name="request")
public class QuestionnaireRequest extends DSRequest {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	@XmlElement(name="QuestionnaireDS") 
	ArrayList<Questionnaire> data;

	public QuestionnaireRequest(){
		data = new ArrayList<Questionnaire>();
	}

	public Collection<Questionnaire> getQuestionnaires() {
		return data;
	}

	public void addQuestionnaire(Questionnaire questionnaire) {

		data.add(questionnaire);
	}

}
