package com.plugtree.smartknowledgediscovery;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.plugtree.smartknowledgediscovery.util.OperationType;
import com.plugtree.smartknowledgediscovery.util.QuestionRequest;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionResourceTest {

	@Test
	public void add() {
	    
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
            httpClient.execute(httpHost, httpPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
