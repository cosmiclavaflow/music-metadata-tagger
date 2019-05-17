package com.music.tagger.listener;

import com.music.tagger.persistence.entity.superclass.MarkedEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public class MarkedEntityListener {

    @PrePersist
//    @PostLoad
    private void prePersist(MarkedEntity entity) {
        entity.setCreationDate(LocalDate.now());
    }

    //@PreUpdate
    //@PrePersist
    private void preUpdate(MarkedEntity entity) {
        entity.setLastUpdateDate(LocalDate.now());
    }
}
