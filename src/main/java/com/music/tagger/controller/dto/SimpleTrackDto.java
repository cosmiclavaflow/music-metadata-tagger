package com.music.tagger.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Data
public class SimpleTrackDto {

    @Length(min = 1, max = 16, message = "Too long artist name")
    private String artistName;

    @Length(min = 1, max = 16, message = "Too long album name")
    private String albumName;

    @URL(message = "There are at least one element is not a Url")
    private List<String> albumCover;

    @Length(min = 1, max = 16, message = "Too long track name")
    private String trackName;
}
