package com.plugtree.smartprocessdiscovery.model.common;

import java.util.List;

public interface Categorizable {
    public List<Category> getCategories();
    public void addCategory(Category category);
}
