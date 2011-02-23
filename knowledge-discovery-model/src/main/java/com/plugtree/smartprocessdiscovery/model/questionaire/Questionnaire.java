package com.plugtree.smartprocessdiscovery.model.questionaire;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.plugtree.smartprocessdiscovery.model.common.Categorizable;
import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.common.Taggeable;

public class Questionnaire implements Categorizable, Taggeable {

	private Long id;
    private String name;
    private List<Category> categories;
    private Set<String> tags;
    private List<Question> questions = new ArrayList<Question>();

    private Long goalId;
    
    public Questionnaire() {
		
	}

    public Questionnaire(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
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
    
    public void removeQuestion(Question question) {
    	// TODO eliminar la pregunta de todos los answered questionnaires
    	if(this.questions!=null) {
    		this.questions.remove(question);
    	}
    }

    public Set<String> getTags() {
        return this.tags;
    }


    
    public void addCategory(Category category) {
        if( this.categories == null ){
            this.categories = new ArrayList<Category>();

        }
        this.categories.add(category);
    }
    
    public void removeCategory(Category category) {
    	if(this.categories!=null) {
    		this.categories.remove(category);
    	}
    }

    public void addTag(String tag) {
        if( this.tags == null){
            this.tags = new HashSet<String>();
        }
        this.tags.add(tag);
    }
    
    public void removeTag(String tag) {
    	if( this.tags != null) {
    		this.tags.remove(tag);
    	}
    }
    
}
