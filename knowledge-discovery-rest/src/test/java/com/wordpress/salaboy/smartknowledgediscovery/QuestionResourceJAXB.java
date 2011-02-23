package com.wordpress.salaboy.smartknowledgediscovery;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import com.wordpress.salaboy.smartknowledgediscovery.util.QuestionRequest;

public class QuestionResourceJAXB {
	@Test
	public void addQuestion(){
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(QuestionRequest.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			QuestionRequest questionRequest = new QuestionRequest();
			
			marshaller.marshal(questionRequest, System.out);
			
		} catch (JAXBException exception) {
			exception.printStackTrace();
		}		
	}
}
