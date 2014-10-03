package org.revo.dao;

import java.util.List;
import org.revo.entity.Post;

/**
 *
 * @author revo
 */
public interface PostDao extends GenericDao<Post> {

    public List<Post> posts(int first, int max);
}
