package com.plugtree.smartknowledgediscovery;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import com.plugtree.smartknowledgediscovery.util.QuestionRequest;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionResourceJAXB {
	@Test
	public void addQuestion(){
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(QuestionRequest.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			QuestionRequest qr = new QuestionRequest();
		    Question question1 = new Question();
		    question1.addTag("TestTag1");
			question1.setText("What time is it?");
			Question question2 = new Question();
			question2.addTag("TestTag2");
			question2.setText("What Day is it?");
			
			qr.getQuestions().add(question1);
			qr.getQuestions().add(question2);
									
			marshaller.marshal(qr, System.out);
			
		} catch (JAXBException exception) {
			exception.printStackTrace();
		}		
	}
}
