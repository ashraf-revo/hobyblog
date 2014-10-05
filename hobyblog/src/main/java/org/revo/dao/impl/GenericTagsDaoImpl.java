package org.revo.dao.impl;

import org.revo.dao.TagsDao;
import org.revo.entity.Tags;
import org.springframework.stereotype.Repository;

@Repository
public class GenericTagsDaoImpl extends GenericDaoImpl<Tags> implements TagsDao {

    public GenericTagsDaoImpl() {
        typeClass = Tags.class;
    }
}
