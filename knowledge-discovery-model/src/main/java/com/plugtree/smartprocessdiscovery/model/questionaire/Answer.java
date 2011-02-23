package com.plugtree.smartprocessdiscovery.model.questionaire;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.plugtree.smartprocessdiscovery.model.common.Categorizable;
import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.common.Taggeable;

public class Answer implements Categorizable, Taggeable {
    private Long id;
    private Question question;
    private String text;
    private List<Category> categories;
    private Set<String> tags;

    public Answer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void addCategory(Category category) {
        if ( this.categories == null ){
            this.categories =  new ArrayList<Category>();
        }
        this.categories.add(category);
    }

    public Set<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        if ( this.tags == null ){
            this.tags = new HashSet<String>();
        }
        this.tags.add(tag);
    }
}
