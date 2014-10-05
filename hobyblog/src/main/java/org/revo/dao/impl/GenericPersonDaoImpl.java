/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.revo.dao.PersonDao;
import org.revo.entity.Person;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author revo
 */
@Repository
public class GenericPersonDaoImpl extends GenericDaoImpl<Person> implements
		PersonDao {

	public GenericPersonDaoImpl() {
		typeClass = Person.class;
	}

	
        @Override
	public Person GetByEmail(String Email) {
		Criteria criteria = getSession().createCriteria(typeClass);
		@SuppressWarnings("unchecked")
		List<Person> l = criteria.add(Restrictions.eq("email", Email)).list();
		if (l.size() == 1)
			return l.get(0);
		else{
		return new Person(Email, Email, Email);}
	}

}
