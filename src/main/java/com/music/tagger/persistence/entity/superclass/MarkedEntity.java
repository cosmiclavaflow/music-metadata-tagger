package com.music.tagger.persistence.entity.superclass;

import com.music.tagger.listener.MarkedEntityListener;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(value = {MarkedEntityListener.class})
public abstract class MarkedEntity extends BasicEntity {

    @Column(name = "creation_date")
    private LocalDate creationDate;
}
