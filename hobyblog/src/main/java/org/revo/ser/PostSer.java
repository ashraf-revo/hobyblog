package org.revo.ser;

import java.io.Serializable;
import java.util.List;
import org.revo.entity.Person;
import org.revo.entity.Post;

public interface PostSer extends GenericSer<Post> {

    public List<Post> posts(int first, int max);

    public Serializable newpost(Post post, Person GetByEmail);
}
