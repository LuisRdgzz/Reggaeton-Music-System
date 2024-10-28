package com.reggaeton.artists.reggaeton_artists.Controller;

import com.reggaeton.artists.reggaeton_artists.Entity.Album;
import com.reggaeton.artists.reggaeton_artists.Entity.Artist;
import com.reggaeton.artists.reggaeton_artists.Service.AlbumService;
import com.reggaeton.artists.reggaeton_artists.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /*FIRST STEP FOR SHOWING ARTIST IN SELECT*/
     @Autowired
     private ArtistService artistService;
     /*Llamamo el metodo artistService para que en un select se muestre todos los artista almacenado en la base de datos*/
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


    /**************************************************** METHOD FOR SAVING ALBUM *************************************/
    @GetMapping("/album/new")
    public String showAlbumRegistrationForm (Model model){
        Album album = new Album();
        model.addAttribute("album" ,album);

        /*SECOND STEP FOR SHOWING ARTIST IN SELECT*/
        List<Artist> artists = artistService.listAllArtist();
        model.addAttribute("artists" , artists);

        return "Album/newAlbum";
    }

    @PostMapping ("/album")
    public String saveAlbum(@ModelAttribute ("album") Album album){
        albumService.SaveAlbum(album);//llamamos el servicio para guardar el objecto
        return "redirect:album";
    }
    /******************************************************************************************************************/


    /**************************************************** METHOD FOR DELETE ALBUM *************************************/
    @PostMapping("/album/{id}/delete")
    public String DeleteAlbum(@PathVariable Long id , RedirectAttributes redirectAttributes){

        try {
            albumService.DeleteAlbum(id);
            redirectAttributes.addFlashAttribute("success", "Successfully delete album");
            return "redirect:album";
        }catch (DataIntegrityViolationException e){
            redirectAttributes.addFlashAttribute("error" , "You can delete this record");
            return "redirect:album";
        }
    }
    /******************************************************************************************************************/


}
