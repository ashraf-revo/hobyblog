package org.revo.ser;

import java.util.List;
import org.revo.entity.Person;
import org.revo.entity.Post;

public interface PostSer extends GenericSer<Post> {

    public List<Post> posts(int first, int max);

    public void newpost(Post post, Person GetByEmail);
}
