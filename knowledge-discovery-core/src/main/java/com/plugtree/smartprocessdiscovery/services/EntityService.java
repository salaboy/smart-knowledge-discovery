package com.plugtree.smartprocessdiscovery.services;

import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

import java.util.List;

public interface EntityService<T> {

	void save(T entity);

    void remove(T entity);

	T findById(Long id);

    T update(T entity);

    List<T> listAll();

    Class<T> getPersistedClass();
}
