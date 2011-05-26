package com.plugtree.smartprocessdiscovery.services;

import java.util.List;

public interface Repository<T> {

	public List<T> findAll();

	public List<T> findAllWithFilter(String filter);

	public Long add(T element);

	public boolean remove(Long id) throws RepositoryException;

	public boolean update(T element) throws RepositoryException;

	public T get(Long id);	
}
