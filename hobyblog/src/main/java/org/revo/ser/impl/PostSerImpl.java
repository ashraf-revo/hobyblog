/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.ser.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.revo.dao.PostDao;
import org.revo.entity.Person;
import org.revo.entity.Post;
import org.revo.entity.PostTags;
import org.revo.entity.Tags;
import org.revo.ser.PostSer;
import org.revo.ser.PostTagsSer;
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
    private PostDao postDao;
    @Autowired
    TagsSer tagsSer;
    @Autowired
    PostTagsSer postTagsSer;

    @Override
    public List<Post> posts(int first, int max) {
        return postDao.posts(first, max);
    }

    @Override
    public void create(Post entity) {
        postDao.create(entity);
    }

    @Override
    public Post GetByRestrictions(Criterion Criterion) {
        return postDao.GetByRestrictions(Criterion);
    }

    @Override
    public void update(Post entity) {
        postDao.update(entity);
    }

    @Override
    public long ByProjection(Projection Projection) {
        return postDao.ByProjection(Projection);
    }

    @Override
    public Serializable newpost(Post post, Person Person) {
        Serializable id = postDao.newpost(post, Person);
        String[] split = post.getTxtTags().split(",");
        for (String tagname : split) {
            if (tagsSer.GetByRestrictions(Restrictions.eq("name", tagname)) == null) {
                tagsSer.create(new Tags(tagname));
            }
            Tags TAG = tagsSer.GetByRestrictions(Restrictions.eq("name", tagname));
            postTagsSer.create(new PostTags(postDao.Getentity(id), TAG));
        }
return id;
    }

}
