/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.revo.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author revo
 * @param <T>
 */
public class GenericDaoImpl<T> implements GenericDao<T> {

	@Autowired
	private SessionFactory factory;
	@SuppressWarnings("rawtypes")
	public Class typeClass;

	public Session getSession() {
		return factory.getCurrentSession();
	}

	
	public void create(T entity) {
		getSession().save(entity);

	}

	@SuppressWarnings("unchecked")
	
	public T GetByRestrictions(Criterion Criterion) {
		Criteria criteria=getSession().createCriteria(typeClass);
		criteria.add(Criterion);
		return (T) criteria.list().get(0);
	}

	
	public void update(T entity) {
	 getSession().update(entity);
		
	}
	
	public long ByProjection(Projection Projection) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(typeClass);
		criteria.setProjection(Projection);
		return Integer.valueOf((criteria.list().toString().replace("[", "")
				.replace("]", "")));
	}


}
