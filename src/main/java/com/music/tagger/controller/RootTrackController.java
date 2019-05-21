package com.music.tagger.controller;

import com.music.tagger.controller.dto.SimpleTrackDto;
import com.music.tagger.persistence.entity.Track;
import com.music.tagger.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.music.tagger.utils.ComplexDomainObjectCreator.getEmptyTrack;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RootTrackController {

    private final ModelMapper modelMapper;

    private final TrackService trackService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SimpleTrackDto getTrackById(@PathVariable("id") long id) throws Exception {
        SimpleTrackDto trackDto = new SimpleTrackDto();
        modelMapper.map(trackService.findById(id), trackDto);
        return trackDto;
    }


    @PostMapping(value = "/addTrack")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@ModelAttribute("track") SimpleTrackDto trackDto, BindingResult result) {
        if (result.hasErrors()) {
            return "home";
        }
        Track track = getEmptyTrack();
        modelMapper.map(trackDto, track);
        trackService.saveAndFlush(track);
        return "good_result";
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTrackById(@PathVariable("id") long id) {
        trackService.deleteById(id);
        return "good_result";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateTrack(@PathVariable("id") long id, @ModelAttribute("track") SimpleTrackDto trackDto)
            throws Exception {
        Track track = trackService.findById(id);
        modelMapper.map(trackDto, track);
        trackService.saveAndFlush(track);
        return "good_result";
    }
}
