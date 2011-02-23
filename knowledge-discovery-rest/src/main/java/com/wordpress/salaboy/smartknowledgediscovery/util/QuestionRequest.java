package com.wordpress.salaboy.smartknowledgediscovery.util;


import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

@XmlRootElement(name="request")
public class QuestionRequest extends DSRequest {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	@XmlElement(name="QuestionDS") 
	ArrayList<Question> data;

	public Collection<Question> getQuestions() {
		return data;
	}

	public void addQuestion(Question question) {
		if (data == null) {
			data = new ArrayList<Question>();
		}
		data.add(question);
	}
}
