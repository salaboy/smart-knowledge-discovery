package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

@XmlRootElement(name="response")
public class QuestionnaireResponse extends DSResponse {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	@XmlElement(name="record")
	ArrayList<Questionnaire> data;

	public QuestionnaireResponse(){
		data = new ArrayList<Questionnaire>();
	}

	public Collection<Questionnaire> getQuestionnaire() {
		return data;
	}

	public void addQuestionnaire(Questionnaire questionnaire) {

		data.add(questionnaire);
		incrementTotalRows();
	}
}
