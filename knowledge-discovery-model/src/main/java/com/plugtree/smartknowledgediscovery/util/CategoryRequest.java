package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.plugtree.smartprocessdiscovery.model.common.Category;

@XmlRootElement(name="request")
public class CategoryRequest extends DSRequest {

    @XmlElementWrapper(name="data")
    @XmlElement(name="CategoryDS")
    ArrayList<Category> data = new ArrayList<Category>();

    public Collection<Category> getCategories() {
        return data;
    }

    public void addQuestion(Category category) {
        data.add(category);
    }
}
