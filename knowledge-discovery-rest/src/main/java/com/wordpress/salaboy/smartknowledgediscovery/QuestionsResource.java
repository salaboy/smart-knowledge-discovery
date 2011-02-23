package com.wordpress.salaboy.smartknowledgediscovery;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.QuestionService;
 
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
