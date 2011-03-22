package com.plugtree.smartprocessdiscovery.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.plugtree.smartprocessdiscovery.dao.GenericDao;

/**
 * creation date: 2/23/11
 */
public abstract class GenericDaoJpa<T> implements GenericDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(T question) {
        entityManager.persist(question);
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(getPersistedClass(), id);
    }

    @Override
    public void remove(T entity){
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public List<T> listAll() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(getPersistedClass());
        Root<T> entity = query.from(getPersistedClass());

        return entityManager.createQuery(query.select(entity)).getResultList();
    }

    @Override
    public List<T> listWithFilter(String filter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(getPersistedClass());
        Root<T> entity = query.from(getPersistedClass());
        query.where(cb.like(entity.get("text").as(String.class), "%" + filter+ "%"));

        return entityManager.createQuery(query.select(entity)).getResultList();
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
