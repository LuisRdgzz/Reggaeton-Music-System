package com.reggaeton.artists.reggaeton_artists.Controller;

import com.reggaeton.artists.reggaeton_artists.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public String listAlbums(Model model){
        List<Object[]> albumWithArtist = albumService.getAllAlbumArtist();
        model.addAttribute("albumWithArtist" , albumWithArtist);
        return "Album/album";
    }

    /*Show info of album*/
    @GetMapping("/album/about")
    public String infoAlbum(Model model){

        return "Album/infoAlbum";
    }

}
