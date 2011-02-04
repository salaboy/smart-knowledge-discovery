package com.worpdress.salaboy.smartprocessdiscovery.model.common;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: salaboy
 * Date: 2/4/11
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Taggeable {
    public Set<String> getTags();
    public void addTag(String tag);
}
