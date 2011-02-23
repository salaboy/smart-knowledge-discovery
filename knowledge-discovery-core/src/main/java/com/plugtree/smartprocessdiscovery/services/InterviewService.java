package com.plugtree.smartprocessdiscovery.services;

import java.util.Collection;
import java.util.Date;

import com.plugtree.smartprocessdiscovery.model.process.Interview;

public interface InterviewService {

	public Collection<Interview> findAll();

	public Long create(String description, Long questionnaireId,
			Long personId);

	public boolean remove(Long id);

	public boolean update(Long id, String description, Date dueDate,
			Date startDate, Date endDate, Long questionnaireId, Long personId);

	public Interview get(Long id);

	public boolean addAnswer(Long id, Long questionId, String text);

	public boolean removeAnswer(Long id, Long questionId);

}