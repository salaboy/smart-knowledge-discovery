package com.wordpress.salaboy.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

@XmlRootElement(name="response")
public class QuestionResponse extends DSResponse {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	@XmlElement(name="record")
	ArrayList<Question> data;

	public QuestionResponse(){
		data = new ArrayList<Question>();
	}

	public Collection<Question> getQuestions() {
		return data;
	}

	public void addQuestion(Question question) {

		data.add(question);
	}


}
