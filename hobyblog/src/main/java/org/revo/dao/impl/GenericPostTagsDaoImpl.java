package org.revo.dao.impl;

import org.revo.dao.PostTagsDao;
import org.revo.entity.PostTags;
import org.springframework.stereotype.Repository;

@Repository
public class GenericPostTagsDaoImpl extends GenericDaoImpl<PostTags> implements PostTagsDao {

    public GenericPostTagsDaoImpl() {
        typeClass = PostTags.class;
    }
}
