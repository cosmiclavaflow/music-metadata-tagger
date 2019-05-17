package com.music.tagger;

import com.music.tagger.persistence.entity.Album;
import com.music.tagger.persistence.entity.Artist;
import com.music.tagger.persistence.entity.Track;
import com.music.tagger.persistence.repository.AlbumRepository;
import com.music.tagger.persistence.repository.ArtistRepository;
import com.music.tagger.dto.SimpleTrackDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@SpringBootApplication
@Transactional
public class CommandLineApplicationRunner implements CommandLineRunner {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public static void main(String[] args) {
        SpringApplication.run(CommandLineApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) {
        Artist artist = new Artist();
        artist.setName("Drake");

        Album firstAlbum = new Album();
        firstAlbum.setName("Panamera");
        firstAlbum.setAlbumCoverList(Arrays.asList("img1A", "img2A", "img3A", "img4A", "img5A"));

        Track track = new Track();
        track.setName("R U Mine");
        track.setAlbum(firstAlbum);
        track.setArtist(artist);

        firstAlbum.setArtist(artist);
        Album secondAlbum = new Album();
        secondAlbum.setName("Fun Elle Funning");
        secondAlbum.setArtist(artist);
        secondAlbum.setAlbumCoverList(Arrays.asList("img1B", "img2B", "img3B", "img4B", "img5B"));

        Track track2 = new Track();
        track.setName("Faith In Love");
        track2.setAlbum(secondAlbum);
        track2.setArtist(artist);

        firstAlbum.setTrackList(Arrays.asList(track));
        secondAlbum.setTrackList(Arrays.asList(track2));

        artist.setAlbumList(Arrays.asList(firstAlbum, secondAlbum));

        artistRepository.saveAndFlush(artist);

        artistRepository.findAll().get(0).getAlbumList().forEach(e -> System.out.println(e.getName()));
        System.out.println("******************************");

        SimpleTrackDto simpleTrackDto = new SimpleTrackDto();
        modelMapper.map(track, simpleTrackDto);


        System.out.println("GGGGGGGGG");
        System.out.println(simpleTrackDto.toString());

    }
}