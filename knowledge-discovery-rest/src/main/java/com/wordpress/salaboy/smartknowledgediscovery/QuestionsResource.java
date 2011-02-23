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
    public Response addQuestion(Question question){
        questionService.add(question);
		
		return Response.created(URI.create("/" + (question.getId() - 1))).build();
    }
	
	@POST
    @Consumes("application/xml")    
    @Path("remove")
    public Response removeQuestion(Long id){
        questionService.removeById(id);
		
		return Response.created(URI.create("/" + id + - 1)).build();
    }
	
	//TODO:  Use JAXB to parse XML or JSON instead of XML.  
	//TODO: Modify to support real questions and SmartGwt.
		
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }
}
