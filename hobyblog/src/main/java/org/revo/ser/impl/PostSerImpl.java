/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.ser.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.revo.dao.PostDao;
import org.revo.entity.Post;
import org.revo.ser.PostSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author revo
 */
@Service
@Transactional
public class PostSerImpl implements PostSer {

	@Autowired
	private PostDao dao;

	
	public List<Post> posts(int first, int max) {
		return dao.posts(first, max);
	}

	
	public void create(Post entity) {
		dao.create(entity);
	}

	
	public Post GetByRestrictions(Criterion Criterion) {
		return dao.GetByRestrictions(Criterion);
	}

	
	public void update(Post entity) {
		dao.update(entity);
	}

	
	public long ByProjection(Projection Projection) {
		return dao.ByProjection(Projection);
	}

}
