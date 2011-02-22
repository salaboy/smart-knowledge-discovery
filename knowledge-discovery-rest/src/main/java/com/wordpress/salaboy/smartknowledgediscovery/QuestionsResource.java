package com.wordpress.salaboy.smartknowledgediscovery;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.wordpress.salaboy.smartknowledgediscovery.services.QuestionService;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;
 
@Path("question")
public class QuestionsResource {
    
	private QuestionService questionService;
	
	@POST
    @Consumes("application/xml")    
    @Path("add")
    public Response addQuestion(InputStream questionData) throws IOException, ParserConfigurationException, SAXException {
        
		Question question = buildQuestion(questionData);
		questionService.add(question);
		
		return Response.created(URI.create("/" + (question.getId() - 1))).build();
    }
	
	//TODO:  Use JAXB to parse XML or JSON instead of XML.  
	//TODO: Modify to support real questions and SmartGwt.
	private Question buildQuestion(InputStream questionData) throws ParserConfigurationException, SAXException, IOException {

		Question question = new Question();

		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document document = documentBuilder.parse(questionData);
		document.getDocumentElement().normalize();

		NodeList nodeList = document.getElementsByTagName("question");
		Node customerRoot = nodeList.item(0);

		if (customerRoot.getNodeType() == Node.ELEMENT_NODE) {

			Element element = (Element)customerRoot;
			NodeList childNodes = element.getChildNodes();

			for (int i = 0; i < childNodes.getLength(); i++) {

				Element childElement = (Element)childNodes.item(i);
				String tagName = childElement.getTagName();
				System.out.println(tagName);
				String textContent = childElement.getTextContent();
				System.out.println(textContent);

				if (tagName.equals("text")) {
					question.setText(textContent);
				} else if (tagName.equals("description")) {
					question.setNotes(textContent);
				}            
			}
		} 

		return question;
	}

	//TODO: Support for smartgwt.
	@GET
	@Produces("application/xml")
	@Path("get/{id}")
	public StreamingOutput getQuestion(@PathParam ("id") String questionId) {

		final Question question = questionService.findById(Long.parseLong(questionId));
		
		return new StreamingOutput() {
			public void write(OutputStream outputStream) {
				PrintWriter out = new PrintWriter(outputStream);
				
				out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
							"<question>" + 
							"<text>" + question.getText() + "</text>" + 
							"<description>" + question.getNotes() + "</description>" +
							"</question>");
				out.close();
			}

		};
	}
}
