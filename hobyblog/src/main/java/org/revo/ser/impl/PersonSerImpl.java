package org.revo.ser.impl;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.revo.dao.PersonDao;
import org.revo.entity.Person;
import org.revo.ser.PersonSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonSerImpl implements PersonSer {
	@Autowired
	private PersonDao dao;

	
	public void create(Person Person) {
		dao.create(Person);
	}

	
	public Person GetByEmail(String Email) {
		return dao.GetByEmail(Email);
	}

	
	public Person GetByRestrictions(Criterion Criterion) {
		return dao.GetByRestrictions(Criterion);
	}

	
	public void update(Person entity) {
		dao.update(entity);
	}

	
	public long ByProjection(Projection Projection) {
		return dao.ByProjection(Projection);
	}
}
