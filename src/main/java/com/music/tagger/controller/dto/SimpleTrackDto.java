package com.music.tagger.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Data
public class SimpleTrackDto {

    private String artistName;

    private String albumName;

    @URL(message = "There are at least one element is not a Url")
    private List<String> albumCover;

    private String trackName;
}
