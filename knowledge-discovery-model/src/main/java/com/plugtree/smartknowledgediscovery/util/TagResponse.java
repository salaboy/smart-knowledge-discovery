package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class TagResponse extends DSResponse {
    // Holds all incoming data
    @XmlElementWrapper(name="data")
    @XmlElement(name="record")
    ArrayList<String> data;

    public TagResponse(){
        data = new ArrayList<String>();
    }

    public Collection<String> getTags() {
        return data;
    }

    public void addTag(String tag) {
        data.add(tag);
        incrementTotalRows();
    }
}
