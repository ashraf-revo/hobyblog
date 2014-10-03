package org.revo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.revo.dao.PostDao;
import org.revo.entity.Post;
import org.springframework.stereotype.Repository;
@Repository
public class GenericPostDaoImpl extends GenericDaoImpl<Post> implements PostDao {

    public GenericPostDaoImpl() {
        typeClass = Post.class;
    }

    @SuppressWarnings("unchecked")
	
    public List<Post> posts(int first, int max) {
        Criteria criteria = getSession().createCriteria(typeClass);
        criteria.setFirstResult(first);
        criteria.setMaxResults(max);
        criteria.addOrder(Order.desc("postdate"));
        return criteria.list();
    }
}
