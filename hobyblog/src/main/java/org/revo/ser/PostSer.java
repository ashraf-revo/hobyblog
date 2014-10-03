package org.revo.ser;

import java.util.List;
import org.revo.entity.Post;

public interface PostSer extends GenericSer<Post> {

    public List<Post> posts(int first, int max);
}
