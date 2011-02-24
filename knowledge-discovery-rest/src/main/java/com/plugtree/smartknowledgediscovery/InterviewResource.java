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

import com.plugtree.smartprocessdiscovery.model.process.Interview;
import com.plugtree.smartprocessdiscovery.services.InterviewService;
import com.plugtree.smartprocessdiscovery.services.ServiceException;

@Path("interview")
public class InterviewResource {

    private InterviewService interviewService;
    private static String EOL = "\n";

    @POST
    @Consumes("application/xml")
    @Path("add")
    public Response addInterview(InputStream interviewData) throws IOException, ParserConfigurationException,
            SAXException {

        String description = obtainDescription(interviewData);
        long questionnaireId = obtainQuestionnaireId(interviewData);
        long personId = obtainPersonId(interviewData);
        try {
            Long interviewId = interviewService.create(description, questionnaireId, personId);
            return Response.created(URI.create("/" + (interviewId - 1))).build();
        } catch (ServiceException e) {
            // TODO: add error message into response
            e.printStackTrace();
            return Response.created(URI.create("/error")).status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private long obtainPersonId(InputStream interviewData) {
        // TODO: parse input to obtain the person id
        return 0;
    }

    private long obtainQuestionnaireId(InputStream interviewData) {
        // TODO: parse input to obtain the questionnaire id
        return 0;
    }

    private String obtainDescription(InputStream interviewData) {
        // TODO: parse input to obtain the description
        return null;
    }

    @GET
    @Produces("application/xml")
    @Path("get/{id}")
    public StreamingOutput getInterview(@PathParam("id") final String interviewId) {

        final Interview interview;
        try {
            interview = interviewService.get(Long.parseLong(interviewId));
        } catch (final ServiceException e) {
            return new StreamingOutput() {
                public void write(OutputStream outputStream) {
                    PrintWriter out = new PrintWriter(outputStream);
                    out.append("<error>" + EOL);
                    out.append("  <message> " + e.getMessage() + "</message>" + EOL);
                    out.append("<error>" + EOL);
                    out.close();
                }

            };
        }

        return new StreamingOutput() {
            public void write(OutputStream outputStream) {
                PrintWriter out = new PrintWriter(outputStream);
                out.append("<interview>" + EOL);
                out.append("  <id>" + interview.getId() + "</id>" + EOL);
                out.append("  <description>" + interview.getDescription() + "</description>" + EOL);
                out.append("  <duedate>" + interview.getDueDate() + "</duedate>" + EOL);
                out.append("  <enddate>" + interview.getEndDate() + "</enddate>" + EOL);
                out.append("  <person>" + interview.getPerson().getId() + "</person>" + EOL);
                out.append("  <questionnaire>" + interview.getQuestionnaire().getId() + "</questionnaire>" + EOL);
                out.append("</interview>");
                out.close();
            }
        };
    }

    @POST
    @Consumes("application/xml")
    @Path("update")
    public Response updateInterview(Long id, String description, Date dueDate, Date startDate, Date endDate,
            Long questionnaireId, Long personId) {
        try {
            interviewService.update(id, description, dueDate, startDate, endDate, questionnaireId, personId);
        } catch (ServiceException e) {
            // TODO: add error message into response
            return Response.created(URI.create("/error")).status(Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.created(URI.create("/" + id)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("remove")
    public Response remove(Long id) {
        try {
            interviewService.remove(id);
        } catch (ServiceException e) {
            // TODO: add error message into response
            return Response.created(URI.create("/error")).status(Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.created(URI.create("/" + id)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("list")
    public Response findAll(Long id, Long catId) {
        try {
            Collection<Interview> all = interviewService.findAll();
            // TODO: create response message
            return Response.created(URI.create("/" + id)).build();
        } catch (ServiceException e) {
            // TODO: add error message into response
            return Response.created(URI.create("/error")).status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Consumes("application/xml")
    @Path("answer/add")
    public Response addAnswer(Long id, Long questionId, String text) {
        try {
            interviewService.addAnswer(id, questionId, text);
        } catch (ServiceException e) {
            // TODO: add error message into response
            return Response.created(URI.create("/error")).status(Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.created(URI.create("/" + id + -1)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("answer/remove")
    public Response removeAnswer(Long id, Long questionId) {
        try {
            interviewService.removeAnswer(id, questionId);
        } catch (ServiceException e) {
            // TODO: add error message into response
            return Response.created(URI.create("/error")).status(Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.created(URI.create("/" + id + -1)).build();
    }

    public void setInterviewService(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    public InterviewService getInterviewService() {
        return interviewService;
    }

}
