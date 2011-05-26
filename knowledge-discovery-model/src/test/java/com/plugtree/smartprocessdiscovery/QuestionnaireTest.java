package com.plugtree.smartprocessdiscovery;

import org.junit.Test;

import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

public class QuestionnaireTest {

    //TODO: Improve!
    @Test
    public void simpleQuestionnaire() {
        Question question = new Question("This is a simple question?");

        question.addCategory(new Category("My Category"));
        question.addTag("Simple Tag");
        question.addTag("Second Tag");
        
        Questionnaire questionnaire = new Questionnaire("My First Questionnaire");
        questionnaire.addQuestion(question);
        questionnaire.addCategory(new Category("Employee oriented Question"));
        questionnaire.addTag("Employee oriented tag");
        //@TODO: override toString to iterate all the questions inside the questionnaire
        System.out.println("Questionnaire -> "+ questionnaire.toString());
    }
}