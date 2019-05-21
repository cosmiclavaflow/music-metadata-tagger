package com.music.tagger.service;

import com.music.tagger.persistence.entity.superclass.BasicEntity;

public interface Service<T extends BasicEntity> {

    T findById(Long id) throws Exception;

    void saveAndFlush(T entity);

    void deleteById(Long id);
}
