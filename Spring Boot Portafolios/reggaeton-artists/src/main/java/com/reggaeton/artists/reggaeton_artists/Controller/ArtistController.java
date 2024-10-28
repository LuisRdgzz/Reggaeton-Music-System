package com.reggaeton.artists.reggaeton_artists.Controller;

import com.reggaeton.artists.reggaeton_artists.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService service;

    @GetMapping("/main")
    public String main(Model modelo){
        return "main";
    }

    @GetMapping("/artist")
    public String artist(Model modelo){
        modelo.addAttribute("artist" ,service.listAllArtist());
        return "artist/artist";
    }

    @GetMapping("/artist/new")
    public String formForCreatinNewArtist(Model modelo){
        //Student estudiante = new Student();
        //modelo.addAttribute("estudiante",estudiante);
        return "artist/newArtist";
    }

    @GetMapping("/artist/about")
    public String infoArtist(Model modelo){

        return "artist/InfoArtist";
    }
}
