/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smartprocessdiscovery.model.questionaire;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class Questionaire {
    private String name;
    private String categories;
    private String tags;
    private List<Question> questions = new ArrayList<Question>();
    private Long processId;

    public Questionaire(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public void addQuestion(Question question){
        if( this.questions == null ){
            this.questions = new ArrayList<Question>();        
        }
        this.questions.add(question);
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    
    public void addCategory(String category) {
        this.categories += ","+category;
    }

    public void addTag(String tag) {
        this.tags += ","+tag;
    }
    
    
}
