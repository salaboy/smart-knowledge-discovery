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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.plugtree.smartprocessdiscovery.services.QuestionnaireService;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Questionnaire;

@Path("questionnaire")
public class QuestionnaireResource {

    private QuestionnaireService questionnaireService;

    @POST
    @Consumes("application/xml")    
    @Path("add")
    public Response addQuestionnaire(InputStream questionnaireData) throws IOException, ParserConfigurationException, SAXException {

        String questionnaireName = buildQuestion(questionnaireData);
        Long questionnaireId = questionnaireService.create(questionnaireName);

        return Response.created(URI.create("/" + (questionnaireId - 1))).build();
    }

    private String buildQuestion(InputStream questionnaireData) throws ParserConfigurationException, SAXException, IOException {
        String questionnaireName = null;
        // TODO: process questionnaireData to obtain the questionnaire name
        return questionnaireName;
    }

    @GET
    @Produces("application/xml")
    @Path("get/{id}")
    public StreamingOutput getQuestionnaire(@PathParam ("id") String questionId) {

        final Questionnaire questionnaire = questionnaireService.get(Long.parseLong(questionId));

        return new StreamingOutput() {
            public void write(OutputStream outputStream) {
                PrintWriter out = new PrintWriter(outputStream);
                // TODO: create output xml
                out.close();
            }

        };
    }

    @POST
    @Consumes("application/xml")
    @Path("update")
    public Response updateQuestionnaire(Long id, String questionnaireName) {
        questionnaireService.update(id, questionnaireName);
        return Response.created(URI.create("/" + id + - 1)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("get")
    public Response getQuestion(Long id) {

        return Response.created(URI.create("/" + id + - 1)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("add-category")
    public Response addCategory(Long id, Long catId) {
        if (!questionnaireService.addCategory(id, catId)) {
            return Response.created(URI.create("/" + id + - 1)).status(Status.FORBIDDEN).build();
        }
        return Response.created(URI.create("/" + id + - 1)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("remove-category")
    public Response removeCategory(Long id, Long catId) {
        if (!questionnaireService.removeCategory(id, catId)) {
            return Response.created(URI.create("/" + id + - 1)).status(Status.FORBIDDEN).build();
        }
        return Response.created(URI.create("/" + id + - 1)).build();
    }
    
    @POST
    @Consumes("application/xml")
    @Path("add-tag")
    public Response addTag(Long id, String tag) {
        if (!questionnaireService.addTag(id, tag)) {
            return Response.created(URI.create("/" + id + - 1)).status(Status.FORBIDDEN).build();
        }
        return Response.created(URI.create("/" + id + - 1)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("remove-tag")
    public Response removeTag(Long id, String tag) {
        if (!questionnaireService.removeTag(id, tag)) {
            return Response.created(URI.create("/" + id + - 1)).status(Status.FORBIDDEN).build();
        }
        return Response.created(URI.create("/" + id + - 1)).build();
    }

    @POST
    @Consumes("application/xml")
    @Path("add-question")
    public Response addQuestion(Long id, Long questionId) {
        if (!questionnaireService.addQuestion(id, questionId)) {
            return Response.created(URI.create("/" + id + - 1)).status(Status.FORBIDDEN).build();
        }
        return Response.created(URI.create("/" + id + - 1)).build();
    }
    
    @POST
    @Consumes("application/xml")
    @Path("remove-question")
    public Response removeQuestion(Long id, Long questionId) {
        if (!questionnaireService.removeQuestion(id, questionId)) {
            return Response.created(URI.create("/" + id + - 1)).status(Status.FORBIDDEN).build();
        }
        return Response.created(URI.create("/" + id + - 1)).build();
    }

    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    public QuestionnaireService getQuestionnaireService() {
        return questionnaireService;
    }

}
