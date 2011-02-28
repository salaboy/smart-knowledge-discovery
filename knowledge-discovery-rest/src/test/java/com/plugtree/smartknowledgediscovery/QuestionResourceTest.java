package com.plugtree.smartknowledgediscovery;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.plugtree.smartknowledgediscovery.util.OperationType;
import com.plugtree.smartknowledgediscovery.util.QuestionRequest;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionResourceTest {

	@Test
	public void addGet() {
	    
	    Question question = new Question();
	    question.setText("What?");
	    question.setNotes("A question.");

	    QuestionRequest questionRequest = new QuestionRequest();
	    questionRequest.setOperationType(OperationType.ADD);
	    questionRequest.getQuestions().add(question);

	    DefaultHttpClient httpClient = new DefaultHttpClient();
	    HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
	    HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/question/add");

	    try {
            JAXBContext jaxbContext = JAXBContext.newInstance(QuestionRequest.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(questionRequest, stringWriter);

            StringEntity entity = new StringEntity(stringWriter.toString());
            httpPost.setEntity(entity);

            httpClient.execute(httpHost, httpPost);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
