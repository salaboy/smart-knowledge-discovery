package com.wordpress.salaboy.smartknowledgediscovery.util;


import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

@XmlRootElement(name="request")
public class QuestionRequest extends DSRequest {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	private	Question data;

	void setData(Question data) {
		this.data = data;
	}

	Question getData() {
		return data;
	}

}
