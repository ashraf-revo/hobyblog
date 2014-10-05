package org.revo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.revo.dao.PostDao;
import org.revo.entity.Person;
import org.revo.entity.Post;
import org.revo.ser.TagsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericPostDaoImpl extends GenericDaoImpl<Post> implements PostDao {

    @Autowired
    TagsSer tagsSer;

    public GenericPostDaoImpl() {
        typeClass = Post.class;
    }

    @SuppressWarnings("unchecked")

    @Override
    public List<Post> posts(int first, int max) {
        Criteria criteria = getSession().createCriteria(typeClass);
        criteria.setFirstResult(first);
        criteria.setMaxResults(max);
        criteria.addOrder(Order.desc("postdate"));
        return criteria.list();
    }

    @Override
    public Serializable  newpost(Post post, Person Person) {
        post.setPerson(Person);
        Person.getPost().add(post);
       return getSession().save(post);
    }

    @Override
    public Post Getentity(Serializable id) {
  return (Post) getSession().get(typeClass, id); }
}
