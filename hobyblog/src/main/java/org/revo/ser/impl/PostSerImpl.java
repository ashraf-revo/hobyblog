/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.ser.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.revo.dao.PostDao;
import org.revo.entity.Person;
import org.revo.entity.Post;
import org.revo.entity.Tags;
import org.revo.ser.PostSer;
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
public class PostSerImpl implements PostSer {

    @Autowired
    private PostDao dao;
    @Autowired
    TagsSer tagsSer;

    @Override
    public List<Post> posts(int first, int max) {
        return dao.posts(first, max);
    }

    @Override
    public void create(Post entity) {
        dao.create(entity);
    }

    @Override
    public Post GetByRestrictions(Criterion Criterion) {
        return dao.GetByRestrictions(Criterion);
    }

    @Override
    public void update(Post entity) {
        dao.update(entity);
    }

    @Override
    public long ByProjection(Projection Projection) {
        return dao.ByProjection(Projection);
    }

    @Override
    public void newpost(Post post, Person Person) {

        String[] split = post.getTxtTags().split(",");
        for (String split1 : split) {
            if (tagsSer.GetByRestrictions(Restrictions.eq("name", split1)) == null) {
                tagsSer.create(new Tags(split1));
            }
        }
        dao.newpost(post,Person);
 }

}
