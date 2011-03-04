package com.plugtree.smartknowledgediscovery;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Collection;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.plugtree.smartknowledgediscovery.util.InterviewRequest;
import com.plugtree.smartknowledgediscovery.util.InterviewResponse;
import com.plugtree.smartknowledgediscovery.util.QuestionResponse;
import com.plugtree.smartprocessdiscovery.model.process.Interview;
import com.plugtree.smartprocessdiscovery.model.questionaire.Answer;
import com.plugtree.smartprocessdiscovery.model.questionaire.AnsweredQuestionnaire;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;
import com.plugtree.smartprocessdiscovery.services.InterviewService;
import com.plugtree.smartprocessdiscovery.services.ServiceException;

@Path("/interview")
public class InterviewResource {

	private InterviewService interviewService;

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/get")
	public InterviewResponse getInterview(InterviewRequest interviewRequest) throws ServiceException{

		InterviewResponse interviewResponse = new InterviewResponse();

		for (Interview interview : interviewService.findAll()) {
			interviewResponse.addInterview(interview);
		}

		interviewResponse.setStatus(InterviewResponse.STATUS_SUCCESS);

		return interviewResponse;
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/add")
	public InterviewResponse addInterview(InterviewRequest interviewRequest) throws ServiceException{

		for (Interview interview : interviewRequest.getInterviews()) {
			interviewService.create(interview.getDescription(),interview.getQuestionnaire().getId(),interview.getPerson().getId());
		}
		
		System.out.println(interviewService.findAll().size());
		
		InterviewResponse interviewResponse = new InterviewResponse();
		interviewResponse.setStatus(InterviewResponse.STATUS_SUCCESS);

		return interviewResponse;
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/update")
	public InterviewResponse updateInterview(InterviewRequest interviewRequest) throws ServiceException {

		for (Interview interview : interviewRequest.getInterviews()) {
			interviewService.update(interview.getId(),
					interview.getDescription(),
					interview.getDueDate(),
					interview.getStartDate(),
					interview.getEndDate(),
					interview.getQuestionnaire().getId(),
					interview.getPerson().getId());
		}

		InterviewResponse interviewResponse = new InterviewResponse();
		interviewResponse.setStatus(InterviewResponse.STATUS_SUCCESS);

		return interviewResponse;
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/remove")
	public InterviewResponse remove(InterviewRequest interviewRequest) throws ServiceException {
		for (Interview interview : interviewRequest.getInterviews()) {
			interviewService.remove(interview.getId());
		}

		InterviewResponse interviewResponse = new InterviewResponse();
		interviewResponse.setStatus(InterviewResponse.STATUS_SUCCESS);

		return interviewResponse;		
	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/list")
	public  InterviewResponse findAll(InterviewRequest interviewRequest) throws ServiceException {
		InterviewResponse interviewResponse = new InterviewResponse();

		for (Interview interview : interviewService.findAll()) {
			interviewResponse.addInterview(interview);
		}

		interviewResponse.setStatus(InterviewResponse.STATUS_SUCCESS);

		return interviewResponse;

	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/answer/add")
	public InterviewResponse addAnswer(InterviewRequest interviewRequest) throws ServiceException {

		for (Interview interview : interviewRequest.getInterviews()) {
			AnsweredQuestionnaire ansQuest = interview.getQuestionnaire();			

			for(Question question : ansQuest.getQuestionnaire().getQuestions()){
				Answer ans = ansQuest.getAnswer(question);
				interviewService.addAnswer(ans.getId(),ans.getQuestion().getId(), ans.getText());
			}
		}
		InterviewResponse interviewResponse = new InterviewResponse();
		interviewResponse.setStatus(InterviewResponse.STATUS_SUCCESS);

		return interviewResponse;


	}

	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/answer/remove")
	public InterviewResponse removeAnswer(InterviewRequest interviewRequest) throws ServiceException {

		for (Interview interview : interviewRequest.getInterviews()) {
			AnsweredQuestionnaire ansQuest = interview.getQuestionnaire();			

			for(Question question : ansQuest.getQuestionnaire().getQuestions()){
				Answer ans = ansQuest.getAnswer(question);
				interviewService.removeAnswer(ans.getId(),question.getId());
			}
		}
		InterviewResponse interviewResponse = new InterviewResponse();
		interviewResponse.setStatus(InterviewResponse.STATUS_SUCCESS);

		return interviewResponse;
	}

	public void setInterviewService(InterviewService interviewService) {
		this.interviewService = interviewService;
	}

	public InterviewService getInterviewService() {
		return interviewService;
	}

}
