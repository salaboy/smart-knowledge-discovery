package com.plugtree.smartprocessdiscovery.dao;

import java.util.List;

public interface GenericDao<T> {

	void save(T entity);

    void remove(T entity);

	T findById(Long id);

    T update(T entity);

    List<T> listAll();

    Class<T> getPersistedClass();
}
