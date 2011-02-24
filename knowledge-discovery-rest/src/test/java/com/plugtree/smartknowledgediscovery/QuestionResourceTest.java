package com.plugtree.smartknowledgediscovery;

import java.io.ByteArrayInputStream;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.junit.Test;

public class QuestionResourceTest {

	@Test
	public void add() {
		String addCustomerXML =
	        "<question>" +
	            "<text>Java or Python?</text>" +
	            "<description>Not relevant.</description>" +
	        "</question>";

		PostMethod postMethod = new PostMethod("http://127.0.0.1:8080/knowledge-discovery-rest/question/add");
	    RequestEntity entity = new InputStreamRequestEntity(new ByteArrayInputStream(addCustomerXML.getBytes()), "application/xml");
	    postMethod.setRequestEntity(entity);
	    HttpClient client = new HttpClient();
	    
	    try {
	    	int result = client.executeMethod(postMethod);
	    	System.out.println("Response status code: " + result);
	    	System.out.println("Response headers:");
	    	
	    	Header[] headers = postMethod.getResponseHeaders();
	    	for (int i = 0; i < headers.length; i++) {
	    		System.out.println(headers[i].toString());
	    	}   	
	    }catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	postMethod.releaseConnection();
	    }	
	}	
}
