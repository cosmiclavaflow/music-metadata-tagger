package com.music.tagger.utils;

import com.music.tagger.persistence.entity.Album;
import com.music.tagger.persistence.entity.Artist;
import com.music.tagger.persistence.entity.Track;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class ComplexDomainObjectCreator {

    public static Track getEmptyTrack(){
        Artist artist = new Artist();
        Album album = new Album();
        Track track = new Track();

        track.setArtist(artist);
        track.setAlbum(album);

        album.setArtist(artist);
        album.setTrackList(Arrays.asList(track));

        artist.setTrackList(Arrays.asList(track));
        artist.setAlbumList(Arrays.asList(album));

        return track;
    }
}
