package com.music.tagger.controller;

import com.music.tagger.persistence.entity.Artist;
import com.music.tagger.persistence.entity.Track;
import com.music.tagger.persistence.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.music.tagger.utils.ComplexDomainObjectCreator.getEmptyArtist;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private final ModelMapper modelMapper;

    private final ArtistRepository artistRepository;

    @PostMapping(value = "/home")
    public String hello(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping(value = "/test")
    public String testResultPage() {
        return "result";
    }

    @GetMapping(value = "/")
    public String hello() {
        return "add_track";
    }

    @PostMapping(value = "/addtrack")
    public String addTrack(@ModelAttribute("track") Track Track, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        Artist artist = getEmptyArtist();
        System.out.println(Track.getName());
        //modelMapper.map(simpleTrackDto, artist);
        //artistRepository.saveAndFlush(artist);

        model.addAttribute("artists", artistRepository.findAll());
        return "result";
    }

}
