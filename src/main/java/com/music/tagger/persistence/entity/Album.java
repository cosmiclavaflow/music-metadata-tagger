package com.music.tagger.persistence.entity;

import com.music.tagger.persistence.entity.superclass.MarkedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Album")
@Table(name = "albums")
@EqualsAndHashCode(callSuper = true)
public class Album extends MarkedEntity {

    @ElementCollection
    @Column(name = "album_cover_list")
    private List<String> albumCoverList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Column(name = "track_list")
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Track> trackList = new ArrayList<>();
}
