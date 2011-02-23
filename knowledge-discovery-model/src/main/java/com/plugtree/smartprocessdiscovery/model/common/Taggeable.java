package com.plugtree.smartprocessdiscovery.model.common;

import java.util.Set;

public interface Taggeable {
    public Set<String> getTags();
    public void addTag(String tag);
}
