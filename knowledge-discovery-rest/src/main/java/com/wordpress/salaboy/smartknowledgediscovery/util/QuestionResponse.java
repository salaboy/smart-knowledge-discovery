package com.wordpress.salaboy.smartknowledgediscovery.util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

@XmlRootElement(name="response")
public class QuestionResponse extends DSResponse {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	@XmlElement(name="record")
	private
	Question data;

	void setData(Question data) {
		this.data = data;
	}

	Question getData() {
		return data;
	}
	
	
}
