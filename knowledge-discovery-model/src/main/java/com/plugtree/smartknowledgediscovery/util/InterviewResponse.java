package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.plugtree.smartprocessdiscovery.model.process.Interview;


@XmlRootElement(name="response")
public class InterviewResponse extends DSResponse {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	@XmlElement(name="record")
	ArrayList<Interview> data;

	public InterviewResponse(){
		data = new ArrayList<Interview>();
	}

	public Collection<Interview> getInterview() {
		return data;
	}

	public void addInterview(Interview interview) {

		data.add(interview);
		incrementTotalRows();
	}
}
