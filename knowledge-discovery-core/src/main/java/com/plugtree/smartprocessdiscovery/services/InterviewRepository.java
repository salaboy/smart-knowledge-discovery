package com.plugtree.smartprocessdiscovery.services;

import java.util.Collection;
import java.util.Date;

import com.plugtree.smartprocessdiscovery.model.process.Interview;

public interface InterviewRepository {

	public Collection<Interview> findAll() throws RepositoryException;

	public Long create(String description, Long questionnaireId,
			Long personId)  throws RepositoryException;

	public boolean remove(Long id)  throws RepositoryException;

	public boolean update(Long id, String description, Date dueDate,
			Date startDate, Date endDate, Long questionnaireId, Long personId)  throws RepositoryException;

	public Interview get(Long id)  throws RepositoryException;

	public boolean addAnswer(Long id, Long questionId, String text)  throws RepositoryException;

	public boolean removeAnswer(Long id, Long questionId)  throws RepositoryException;

}