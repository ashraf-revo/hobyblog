package org.revo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.revo.dao.PostDao;
import org.revo.entity.Person;
import org.revo.entity.Post;
import org.revo.entity.Tags;
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
    public void newpost(Post post, Person Person) {
        post.setPerson(Person);
        String[] split = post.getTxtTags().split(",");
        for (String split1 : split) {
            Tags tag = tagsSer.GetByRestrictions(Restrictions.eq("name", split1));
            System.out.println(tag.getName());
//         post.getTags().add(tag);
       //  tag.getPost().add(post);
         }

        Person.getPost().add(post);
        create(post);
    }
}
