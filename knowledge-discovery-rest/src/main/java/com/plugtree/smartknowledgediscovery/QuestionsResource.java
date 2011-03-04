package com.plugtree.smartknowledgediscovery;

import java.net.URI;
import java.util.Collection;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.plugtree.smartknowledgediscovery.util.QuestionRequest;
import com.plugtree.smartknowledgediscovery.util.QuestionResponse;
import com.plugtree.smartprocessdiscovery.dao.GenericDao;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;


@Path("/question")
public class QuestionsResource {

	private GenericDao<Question> questionService;

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/get")
	public QuestionResponse getQuestion(QuestionRequest questionRequest) {

		QuestionResponse questionResponse = new QuestionResponse();

		for (Question question : questionService.listAll()) {
			questionResponse.addQuestion(question);
		}				
		questionResponse.setStatus(QuestionResponse.STATUS_SUCCESS);

		return questionResponse;
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/add")
	public QuestionResponse addQuestion(QuestionRequest questionRequest) {

		for (Question question : questionRequest.getQuestions()) {
			questionService.save(question);
		}

		QuestionResponse questionResponse = new QuestionResponse();
		questionResponse.setStatus(QuestionResponse.STATUS_SUCCESS);

		return questionResponse;
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/remove")
	public QuestionResponse removeQuestion(QuestionRequest questionRequest){

		for (Question question : questionRequest.getQuestions()) {
			questionService.remove(question);;
		}

		QuestionResponse questionResponse = new QuestionResponse();
		questionResponse.setStatus(QuestionResponse.STATUS_SUCCESS);

		return questionResponse;
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/update")
	public QuestionResponse updateQuestion(QuestionRequest questionRequest){

		for (Question question : questionRequest.getQuestions()) {
			questionService.update(question);	
		}

		QuestionResponse questionResponse = new QuestionResponse();
		questionResponse.setStatus(QuestionResponse.STATUS_SUCCESS);

		return questionResponse;
	}

	public void setQuestionService(GenericDao<Question> questionService) {
		this.questionService = questionService;
	}

	public GenericDao<Question> getQuestionService() {
		return questionService;
	}
}
