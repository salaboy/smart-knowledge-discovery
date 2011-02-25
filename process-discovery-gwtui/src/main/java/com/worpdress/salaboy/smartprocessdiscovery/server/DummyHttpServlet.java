package com.worpdress.salaboy.smartprocessdiscovery.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.plugtree.smartknowledgediscovery.util.QuestionRequest;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.ContentsType;


public class DummyHttpServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		resp.setContentType("text/xml");
		PrintWriter out = resp.getWriter();
		out.println("<response>"+
				" <status>0</status>"+
				"<startRow>0</startRow>"+
				"<endRow>0</endRow>"+
				"<totalRows>1</totalRows>"+
				"<data>"+
				"<record>"+
				"<id>1</id>"+
				"<question>"+ "What's your favorite Horror movie?" +"</question>"+
				"<description>"+ "Horror Movie Question" +"</description>"+
				"<category>"+ "Movie" +"</category>"+
				"</record>"+
				"</data>"+
		"</response>");

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
	
		//Shows the content type, in this case text/xml
		System.out.println(req.getContentType());
		
		//Shows the URL of the service Required
		System.out.println(req.getPathInfo());
		
		//The xml received in the request.
		BufferedReader in = req.getReader();
		String str;
		 while ((str = in.readLine()) != null) {
		        System.out.println(str);
		    }

		 
		
		resp.setContentType("text/xml");
		PrintWriter out = resp.getWriter();
		out.println("<response>"+
				" <status>0</status>"+
				"<startRow>0</startRow>"+
				"<endRow>0</endRow>"+
				"<totalRows>1</totalRows>"+
				"<data>"+
				"<record>"+
				"<id>1</id>"+
				"<question>"+ "What's your favorite Horror movie?" +"</question>"+
				"<description>"+ "Horror Movie Question" +"</description>"+
				"<category>IT</category>"+
				"</record>"+
				"</data>"+
		"</response>");

	}
}
