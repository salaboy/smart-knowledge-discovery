/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.worpdress.salaboy.smartprocessdiscovery.model.questionaire;

import com.worpdress.salaboy.smartprocessdiscovery.model.common.Categorizable;
import com.worpdress.salaboy.smartprocessdiscovery.model.common.Category;
import com.worpdress.salaboy.smartprocessdiscovery.model.common.Taggeable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author salaboy
 */

public class Question implements Categorizable, Taggeable {
    private Long id;
    private String text;
    private String notes;
    private List<Category> categories;
    private Set<String> tags;


    public Question(String text) {
        this.text = text;
    }



    public Question() {
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


    public List<Category> getCategories() {
        return this.categories;
    }

    public void addCategory(Category category) {
        if(this.categories == null){
             this.categories =  new ArrayList<Category>();
        }
        this.categories.add(category);
    }

    public Set<String> getTags() {

        return this.tags;
    }

    public void addTag(String tag) {
        if(this.tags == null){
            this.tags = new HashSet<String>();

        }
        this.tags.add(tag);
    }
    
    
    
    
    
}
