package com.music.tagger.exceptions;

public class TrackNotFoundException extends Exception {


    public TrackNotFoundException() {
        super();
    }


    public TrackNotFoundException(String message) {
        super(message);
    }
}
