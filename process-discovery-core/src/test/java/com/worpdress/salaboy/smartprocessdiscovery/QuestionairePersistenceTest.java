/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smartprocessdiscovery;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;
import org.junit.Test;

/**
 *
 * @author salaboy
 */
public class QuestionairePersistenceTest  {
    
    public QuestionairePersistenceTest() {

    }


    protected void setUp() throws Exception {

    }


    protected void tearDown() throws Exception {

    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
     @Test 
    public void simpleQuestionaireWithPersistence(){
        Question question = new Question("This is a simple question?");

//        question.setCategory("My Category");
//        question.setTag("Simple Tag");
//        question.setTag("Second Tag");
//        
//        Questionnaire questionaire = new Questionnaire("My First Questionnaire");
//        questionaire.addQuestion(question);
//        questionaire.setCategory("Employee oriented Question");
//        questionaire.setTag("Employee oriented tag");
        //@TODO: add persistence
        //em.persist(questionaire);
    }
}
