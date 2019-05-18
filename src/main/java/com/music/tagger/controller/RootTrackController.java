package com.music.tagger.controller;

import com.music.tagger.controller.dto.SimpleTrackDto;
import com.music.tagger.exceptions.TrackNotFoundException;
import com.music.tagger.persistence.entity.Track;
import com.music.tagger.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.music.tagger.utils.ComplexDomainObjectCreator.getEmptyTrack;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RootTrackController {

    private final ModelMapper modelMapper;

    private final TrackService trackService;

    @GetMapping(value = "/{id}")
    public SimpleTrackDto getTrackById(@PathVariable("id") long id) throws Exception {
        SimpleTrackDto trackDto = new SimpleTrackDto();
        modelMapper.map(trackService.findById(id), trackDto);
        return trackDto;
    }


    @PostMapping(value = "/addTrack")
    public String add(@ModelAttribute("track") SimpleTrackDto trackDto, Model model) {
        Track track = getEmptyTrack();
        modelMapper.map(trackDto, track);
        trackService.saveAndFlush(track);
        return "Your track has been added successfully";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteTrackById(@PathVariable("id") long id) {
        trackService.deleteById(id);
        return "Your track is deleting";
    }

    @PutMapping(value = "/{id}")
    public String updateTrack(@PathVariable("id") long id, @ModelAttribute("track") SimpleTrackDto trackDto) {
        Track track = getEmptyTrack();
        modelMapper.map(trackDto, track);
        track.setId(id);
        trackService.saveAndFlush(track);
        return "Your track is updating";
    }
}
