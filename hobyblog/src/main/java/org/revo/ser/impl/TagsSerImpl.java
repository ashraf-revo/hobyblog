/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.ser.impl;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.revo.dao.TagsDao;
import org.revo.entity.Tags;
import org.revo.ser.TagsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author revo
 */
@Service
@Transactional
public class TagsSerImpl implements TagsSer {

    @Autowired
    private TagsDao dao;

    @Override
    public void create(Tags entity) {
        dao.create(entity);
    }

    @Override
    public Tags GetByRestrictions(Criterion Criterion) {
        return dao.GetByRestrictions(Criterion);
    }

    @Override
    public void update(Tags entity) {
        dao.update(entity);
    }

    @Override
    public long ByProjection(Projection Projection) {
        return dao.ByProjection(Projection);
    }

}
