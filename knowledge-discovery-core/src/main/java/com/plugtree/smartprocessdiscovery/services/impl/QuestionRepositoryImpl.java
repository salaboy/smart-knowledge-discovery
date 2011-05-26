package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.List;

import com.plugtree.smartprocessdiscovery.dao.GenericDao;
import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.QuestionRepository;
import com.plugtree.smartprocessdiscovery.services.RepositoryException;

public class QuestionRepositoryImpl implements QuestionRepository {
	
	private GenericDao<Question> questionDao;
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#findAll()
	 */
	@Override
	public List<Question> findAll() {
		
		return questionDao.listAll();
	}

	@Override
	public List<Question> findAllWithFilter(String filter) {

	    return questionDao.listWithFilter(filter);
	}

	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#create(java.lang.String, java.lang.String)
	 */
	@Override
	public Long add(Question question) {
		
		questionDao.save(question);
		
		return question.getId();
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#remove(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) throws RepositoryException {

		Question question = questionDao.findById(id);
		
		if(question == null) {
			throw new RepositoryException("Question doesn't exist");
		}
		
		questionDao.remove(question);

		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#update(java.lang.Long, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean update(Question question) throws RepositoryException {

		questionDao.update(question);
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#get(java.lang.Long)
	 */
	@Override
	public Question get(Long id) {
		return questionDao.findById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#addCategory(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean addCategory(Long qId, Long catId) {
		// TODO buscar pregunta
		Question question = new Question();
		// TODO buscar categoría
		Category category = new Category();
		
		if(question.getCategories().contains(category)) {
			return false;
		}
		
		question.addCategory(category);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#removeCategory(java.lang.Long, java.lang.Long)
	 */
	@Override
	public boolean removeCategory(Long qId, Long catId) {
		// TODO buscar pregunta
		Question question = new Question();
		// TODO buscar categoría
		Category category = new Category();
		
		question.removeCategory(category);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#addTag(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean addTag(String tag) {
		// TODO buscar pregunta
		Question question = new Question();
		
		if(question.getTags().contains(tag)) {
			return false;
		}
		
		question.addTag(tag);
		
		// TODO persistir
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.plugtree.smartprocessdiscovery.services.impl.QuestionInterface#removeTag(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean removeTag(Long id) {
		// TODO buscar pregunta y tag
		Question question = new Question();
		
		question.removeTag("tag");
		
		// TODO persistir
		return true;
	}

	public void setQuestionDao(GenericDao<Question> questionDao) {
		this.questionDao = questionDao;
	}

	public GenericDao<Question> getQuestionDao() {
		return questionDao;
	}
}
