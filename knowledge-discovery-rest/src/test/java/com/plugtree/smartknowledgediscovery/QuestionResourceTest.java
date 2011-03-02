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

import com.plugtree.smartknowledgediscovery.util.OperationType;
import com.plugtree.smartknowledgediscovery.util.QuestionRequest;
import com.plugtree.smartknowledgediscovery.util.QuestionResponse;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionResourceTest {

	@Test
	public void addPost() {

		Question question = new Question();
		question.setText("What?");
		question.setNotes("A question.");

		QuestionRequest questionRequest = new QuestionRequest();
		questionRequest.setOperationType(OperationType.ADD);
		questionRequest.getQuestions().add(question);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
		HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/question/add");
		httpPost.setHeader("Content-type", "application/xml");

		try {
			JAXBContext requestContext = JAXBContext.newInstance(QuestionRequest.class);
			Marshaller marshaller = requestContext.createMarshaller();

			StringWriter requestWriter = new StringWriter();
			marshaller.marshal(questionRequest, requestWriter);

			StringEntity requestEntity = new StringEntity(requestWriter.toString());
			httpPost.setEntity(requestEntity);

			HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
			HttpEntity responseEntity = httpResponse.getEntity();

			InputStream responseStream = responseEntity.getContent();

			JAXBContext responseContext = JAXBContext.newInstance(QuestionResponse.class);
			Unmarshaller unmarhaller = responseContext.createUnmarshaller();

			QuestionResponse questionResponse = (QuestionResponse)unmarhaller.unmarshal(responseStream);

			Assert.assertEquals(questionResponse.getStatus(), QuestionResponse.STATUS_SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updatePost() {

		Question question = new Question();
		question.setId((long) 1);
		question.setText("What's your favorite colour?");
		question.setNotes("A question.UPDATED");


		QuestionRequest questionRequest = new QuestionRequest();
		questionRequest.setOperationType(OperationType.UPDATE);
		questionRequest.getQuestions().add(question);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
		HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/question/update");
		httpPost.setHeader("Content-type", "application/xml");

		try {
			JAXBContext requestContext = JAXBContext.newInstance(QuestionRequest.class);
			Marshaller marshaller = requestContext.createMarshaller();

			StringWriter requestWriter = new StringWriter();
			marshaller.marshal(questionRequest, requestWriter);

			StringEntity requestEntity = new StringEntity(requestWriter.toString());
			httpPost.setEntity(requestEntity);

			HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
			HttpEntity responseEntity = httpResponse.getEntity();

			InputStream responseStream = responseEntity.getContent();

			JAXBContext responseContext = JAXBContext.newInstance(QuestionResponse.class);
			Unmarshaller unmarhaller = responseContext.createUnmarshaller();

			QuestionResponse questionResponse = (QuestionResponse)unmarhaller.unmarshal(responseStream);

			Assert.assertEquals(questionResponse.getStatus(), QuestionResponse.STATUS_SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void removePost() {

		Question question = new Question();
		question.setId((long) 1);

		QuestionRequest questionRequest = new QuestionRequest();
		questionRequest.setOperationType(OperationType.REMOVE);
		questionRequest.getQuestions().add(question);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
		HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/question/remove");
		httpPost.setHeader("Content-type", "application/xml");

		try {
			JAXBContext requestContext = JAXBContext.newInstance(QuestionRequest.class);
			Marshaller marshaller = requestContext.createMarshaller();

			StringWriter requestWriter = new StringWriter();
			marshaller.marshal(questionRequest, requestWriter);

			StringEntity requestEntity = new StringEntity(requestWriter.toString());
			httpPost.setEntity(requestEntity);

			HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
			HttpEntity responseEntity = httpResponse.getEntity();

			InputStream responseStream = responseEntity.getContent();

			JAXBContext responseContext = JAXBContext.newInstance(QuestionResponse.class);
			Unmarshaller unmarhaller = responseContext.createUnmarshaller();

			QuestionResponse questionResponse = (QuestionResponse)unmarhaller.unmarshal(responseStream);

			Assert.assertEquals(questionResponse.getStatus(), QuestionResponse.STATUS_SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
