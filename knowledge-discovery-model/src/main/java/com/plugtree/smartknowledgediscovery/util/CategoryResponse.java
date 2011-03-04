package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.plugtree.smartprocessdiscovery.model.common.Category;

@XmlRootElement(name="response")
public class CategoryResponse extends DSResponse {

    @XmlElementWrapper(name="data")
    @XmlElement(name="record")
    ArrayList<Category> data = new ArrayList<Category>();

    public Collection<Category> getCategories() {
        return data;
    }

    public void addCategory(Category category) {
        data.add(category);
        incrementTotalRows();
    }    
}
