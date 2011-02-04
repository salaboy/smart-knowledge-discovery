package com.worpdress.salaboy.smartprocessdiscovery.model.questionaire;

import com.worpdress.salaboy.smartprocessdiscovery.model.common.Categorizable;
import com.worpdress.salaboy.smartprocessdiscovery.model.common.Category;
import com.worpdress.salaboy.smartprocessdiscovery.model.common.Taggeable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: salaboy
 * Date: 2/4/11
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
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
