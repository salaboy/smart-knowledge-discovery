/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smartprocessdiscovery.model.questionaire;

/**
 *
 * @author salaboy
 */

public class Question {
    private String role;
    private String text;
    private String categories;
    private String notes;
    private String tags;

    public Question(String text) {
        this.text = text;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
