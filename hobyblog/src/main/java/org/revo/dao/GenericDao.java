/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.dao;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;

/**
 * 
 * @author revo
 * @param <T>
 */
public interface GenericDao<T> {
	public void create(T entity);
	public T GetByRestrictions(Criterion  Criterion);
	public void update(T entity);
	public long ByProjection(Projection Projection);
}
