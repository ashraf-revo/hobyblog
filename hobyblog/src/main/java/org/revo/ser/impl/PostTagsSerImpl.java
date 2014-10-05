/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.ser.impl;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.revo.dao.PostTagsDao;
import org.revo.entity.PostTags;
import org.revo.ser.PostTagsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author revo
 */
@Service
@Transactional
public class PostTagsSerImpl implements PostTagsSer {

    @Autowired
    private PostTagsDao dao;

    @Override
    public void create(PostTags entity) {
        dao.create(entity);
    }

    @Override
    public PostTags GetByRestrictions(Criterion Criterion) {
        return dao.GetByRestrictions(Criterion);
    }

    @Override
    public void update(PostTags entity) {
        dao.update(entity);
    }

    @Override
    public long ByProjection(Projection Projection) {
        return dao.ByProjection(Projection);
    }

}
