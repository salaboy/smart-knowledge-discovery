package com.worpdress.salaboy.smartprocessdiscovery.model.common;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: salaboy
 * Date: 2/4/11
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Categorizable {
    public List<Category> getCategories();
    public void addCategory(Category category);
}
