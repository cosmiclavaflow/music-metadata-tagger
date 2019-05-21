package com.music.tagger.listener;

import com.music.tagger.persistence.entity.superclass.MarkedEntity;

import javax.persistence.PrePersist;
import java.time.LocalDate;

public class MarkedEntityListener {

    @PrePersist
    private void prePersist(MarkedEntity entity) {
        entity.setCreationDate(LocalDate.now());
    }
}
