package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.plugtree.smartprocessdiscovery.model.process.Interview;

@XmlRootElement(name="request")
public class InterviewRequest extends DSRequest {
	// Holds all incoming data
	@XmlElementWrapper(name="data")
	@XmlElement(name="InterviewDS") 
	ArrayList<Interview> data;

	public InterviewRequest(){
		data = new ArrayList<Interview>();
	}

	public Collection<Interview> getInterviews() {
		return data;
	}

	public void addInterview(Interview interview) {

		data.add(interview);
	}
}
