package com.plugtree.smartknowledgediscovery.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="request")
public class TagRequest extends DSRequest {
    // Holds all incoming data
    @XmlElementWrapper(name="data")
    @XmlElement(name="TagDS") 
    ArrayList<String> data;

    public TagRequest(){
        data = new ArrayList<String>();
    }
    
    public Collection<String> getTags() {
        return data;
    }

    public void addTag(String tag) {
        data.add(tag);
    }
}

