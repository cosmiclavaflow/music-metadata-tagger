package com.music.tagger.controller;

import com.music.tagger.controller.dto.SimpleTrackDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class HomeController {

    @GetMapping("/track")
    public String showHomePage(@Valid Model model){
        model.addAttribute("track", new SimpleTrackDto());
        return "home";
    }
}
