package com.music.tagger.service;

import com.music.tagger.exceptions.TrackNotFoundException;
import com.music.tagger.persistence.entity.Track;
import com.music.tagger.persistence.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    @Override
    public Track findById(Long id) throws TrackNotFoundException {
        return trackRepository.findById(id).orElseThrow(TrackNotFoundException::new);
    }

    @Override
    public void saveAndFlush(Track entity) {
        trackRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(Long id) {
        trackRepository.deleteById(id);
    }
}
