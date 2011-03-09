package com.plugtree.smartknowledgediscovery;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.plugtree.smartknowledgediscovery.util.InterviewRequest;
import com.plugtree.smartknowledgediscovery.util.InterviewResponse;
import com.plugtree.smartknowledgediscovery.util.OperationType;
import com.plugtree.smartknowledgediscovery.util.QuestionResponse;
import com.plugtree.smartprocessdiscovery.model.process.Interview;
import com.plugtree.smartprocessdiscovery.model.questionaire.AnsweredQuestionnaire;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

public class InterviewResourceTest {
	@Test
	public void addPost() {

		//Interview
		Interview interview = new Interview();
		//AnsweredQuestionnaire
		AnsweredQuestionnaire ansQuestionnaire = new AnsweredQuestionnaire();
		//Questionnaire
		Questionnaire questionnaire = new Questionnaire();
		
		//Question1 of Questionnaire
		Question question1 = new Question();
		question1.setText("What's your name?");
		question1.setNotes("Name :: Question.");
		questionnaire.addQuestion(question1);
		
		//Question2 of Questionnaire
		Question question2 = new Question();
		question2.setText("What's the Weather like?");
		question2.setNotes("Weather :: Question.");
		questionnaire.addQuestion(question2);
		
		ansQuestionnaire.setQuestionnaire(questionnaire);
		
		interview.setQuestionnaire(ansQuestionnaire);

		InterviewRequest interviewRequest = new InterviewRequest();
		interviewRequest.setOperationType(OperationType.ADD);
		interviewRequest.getInterviews().add(interview);
		
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
		HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/interview/add");
		httpPost.setHeader("Content-type", "application/xml");

		try {
			JAXBContext requestContext = JAXBContext.newInstance(InterviewRequest.class);
			Marshaller marshaller = requestContext.createMarshaller();

			StringWriter requestWriter = new StringWriter();
			marshaller.marshal(interviewRequest, requestWriter);

			StringEntity requestEntity = new StringEntity(requestWriter.toString());
			httpPost.setEntity(requestEntity);

			HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
			HttpEntity responseEntity = httpResponse.getEntity();

			InputStream responseStream = responseEntity.getContent();

			JAXBContext responseContext = JAXBContext.newInstance(InterviewResponse.class);
			Unmarshaller unmarhaller = responseContext.createUnmarshaller();

			InterviewResponse interviewResponse = (InterviewResponse)unmarhaller.unmarshal(responseStream);

			Assert.assertEquals(interviewResponse.getStatus(), InterviewResponse.STATUS_SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updatePost() {

		//Interview
		Interview interview = new Interview();
		interview.setId((long)1);
		//AnsweredQuestionnaire
		AnsweredQuestionnaire ansQuestionnaire = new AnsweredQuestionnaire();
		ansQuestionnaire.setId((long)1);
		//Questionnaire
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setId((long)1);
		
		//Question1 of Questionnaire
		Question question1 = new Question();
		question1.setId((long)1);
		question1.setText("What's your name,Sr?");
		question1.setNotes("Name :: Question - UPDATED");
		questionnaire.addQuestion(question1);
		
		ansQuestionnaire.setQuestionnaire(questionnaire);
		
		interview.setQuestionnaire(ansQuestionnaire);
		
		InterviewRequest interviewRequest = new InterviewRequest();
		interviewRequest.setOperationType(OperationType.UPDATE);
		interviewRequest.addInterview(interview);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
		HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/interview/update");
		httpPost.setHeader("Content-type", "application/xml");

		try {
			JAXBContext requestContext = JAXBContext.newInstance(InterviewRequest.class);
			Marshaller marshaller = requestContext.createMarshaller();

			StringWriter requestWriter = new StringWriter();
			marshaller.marshal(interviewRequest, requestWriter);

			StringEntity requestEntity = new StringEntity(requestWriter.toString());
			httpPost.setEntity(requestEntity);

			HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
			HttpEntity responseEntity = httpResponse.getEntity();

			InputStream responseStream = responseEntity.getContent();

			JAXBContext responseContext = JAXBContext.newInstance(InterviewResponse.class);
			Unmarshaller unmarhaller = responseContext.createUnmarshaller();

			InterviewResponse interviewResponse = (InterviewResponse)unmarhaller.unmarshal(responseStream);

			Assert.assertEquals(interviewResponse.getStatus(), InterviewResponse.STATUS_SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void removePost() {

		Interview interview = new Interview();
		interview.setId((long) 1);

		InterviewRequest interviewRequest = new InterviewRequest();
		interviewRequest.setOperationType(OperationType.REMOVE);
		interviewRequest.getInterviews().add(interview);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
		HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/interview/remove");
		httpPost.setHeader("Content-type", "application/xml");

		try {
			JAXBContext requestContext = JAXBContext.newInstance(InterviewRequest.class);
			Marshaller marshaller = requestContext.createMarshaller();

			StringWriter requestWriter = new StringWriter();
			marshaller.marshal(interviewRequest, requestWriter);

			StringEntity requestEntity = new StringEntity(requestWriter.toString());
			httpPost.setEntity(requestEntity);

			HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
			HttpEntity responseEntity = httpResponse.getEntity();

			InputStream responseStream = responseEntity.getContent();

			JAXBContext responseContext = JAXBContext.newInstance(InterviewResponse.class);
			Unmarshaller unmarhaller = responseContext.createUnmarshaller();

			InterviewResponse interviewResponse = (InterviewResponse)unmarhaller.unmarshal(responseStream);

			Assert.assertEquals(interviewResponse.getStatus(), InterviewResponse.STATUS_SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


