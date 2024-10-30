package com.reggaeton.artists.reggaeton_artists.Controller;

import com.reggaeton.artists.reggaeton_artists.Entity.Artist;
import com.reggaeton.artists.reggaeton_artists.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

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
        Artist artist = new Artist();
        modelo.addAttribute("artist" , artist);
        return "artist/newArtist";
    }

    /**/
    @PostMapping("/artist")
    public String saveArtist (@ModelAttribute ("artist")Artist artist,
                              @RequestParam("image")MultipartFile image,
                              @RequestParam("name" )String name,
                              @RequestParam("birthDate") @DateTimeFormat(pattern ="yyyy-MM-dd") Date birthDate,
                              @RequestParam("countryOfOrigin") String countryOfOrigin ,
                              @RequestParam("yearsActive") Integer yearsActive,
                              @RequestParam("biography") String biography){
        try{
            if(!image.isEmpty()){
                byte[] imgBytes = image.getBytes();
                artist.setImg(imgBytes);
            }

            artist.setName(name);
            artist.setBirthDate(birthDate);
            artist.setCountryOfOrigin(countryOfOrigin);
            artist.setYearsActive(yearsActive);
            artist.setBiography(biography);

            service.saveArtist(artist);
            return "artist/artist";

        }catch (IOException e){
            e.printStackTrace();
            return "artist/artist";
        }
    }

    @GetMapping("/artist/about")
    public String infoArtist(Model modelo){

        return "artist/InfoArtist";
    }
}
