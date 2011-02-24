package com.plugtree.smartprocessdiscovery.services;

import java.util.Collection;
import java.util.Date;

import com.plugtree.smartprocessdiscovery.model.process.Interview;

public interface InterviewService {

	public Collection<Interview> findAll() throws ServiceException;

	public Long create(String description, Long questionnaireId,
			Long personId)  throws ServiceException;

	public boolean remove(Long id)  throws ServiceException;

	public boolean update(Long id, String description, Date dueDate,
			Date startDate, Date endDate, Long questionnaireId, Long personId)  throws ServiceException;

	public Interview get(Long id)  throws ServiceException;

	public boolean addAnswer(Long id, Long questionId, String text)  throws ServiceException;

	public boolean removeAnswer(Long id, Long questionId)  throws ServiceException;

}