/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smartprocessdiscovery;

import com.worpdress.salaboy.smartprocessdiscovery.model.common.Category;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Questionnaire;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author salaboy
 */
public class QuestionnaireTest {

    public QuestionnaireTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

   
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