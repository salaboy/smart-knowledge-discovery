/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smartprocessdiscovery;

import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Questionaire;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author salaboy
 */
public class QuestionaireTest {

    public QuestionaireTest() {
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
    public void simpleQuestionaire() {
        Question question = new Question("This is a simple question?");
        question.setRole("Simple Employee");
        question.addCategory("My Category");
        question.addTag("Simple Tag");
        question.addTag("Second Tag");
        
        Questionaire questionaire = new Questionaire("My First Questionaire");
        questionaire.addQuestion(question);
        questionaire.addCategory("Employee oriented Question");
        questionaire.addTag("Employee oriented tag");
        //@TODO: override toString to iterate all the questions inside the questionaire
        System.out.println("Questionaire -> "+questionaire.toString());
        
        
    }
    
   

}