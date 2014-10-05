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

	
        @Override
	public void create(Person Person) {
		dao.create(Person);
	}

	
        @Override
	public Person GetByEmail(String Email) {
		return dao.GetByEmail(Email);
	}

	
        @Override
	public Person GetByRestrictions(Criterion Criterion) {
		return dao.GetByRestrictions(Criterion);
	}

	
        @Override
	public void update(Person entity) {
		dao.update(entity);
	}

	
        @Override
	public long ByProjection(Projection Projection) {
		return dao.ByProjection(Projection);
	}
}
