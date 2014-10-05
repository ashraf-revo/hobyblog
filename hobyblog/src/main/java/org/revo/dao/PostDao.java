package org.revo.dao;

import java.io.Serializable;
import java.util.List;
import org.revo.entity.Person;
import org.revo.entity.Post;

/**
 *
 * @author revo
 */
public interface PostDao extends GenericDao<Post> {

    public List<Post> posts(int first, int max);

    public Serializable newpost(Post post, Person Person);

    public Post Getentity(Serializable id);

}
