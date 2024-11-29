package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumController {

    private final AlbumService albumService;
    public AlbumController(SongService songService, AlbumService albumService){
        this.albumService=albumService;
    }

    @GetMapping("/album")
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("listAlbum",albumService.findAll());
        return "listAlbum";
    }
    @PostMapping("/album/add")
    public String saveAlbum(
            @RequestParam String albumName,
            @RequestParam String albumGenre,
            @RequestParam String releaseYear,
            Model model){

        Album album=albumService.addAlbum(albumName,albumGenre,releaseYear);
        model.addAttribute("listAlbum",albumService.findAll());
        return  "listAlbum";

    }
    @PostMapping("/album/edit/{albumId}")
    public String editSong(@PathVariable Long albumId,
                           @RequestParam String albumName,
                           @RequestParam String albumGenre,
                           @RequestParam String releaseYear,
                           Model model){
        Album album = albumService.modifyAlbum(albumId,albumName,albumGenre,releaseYear);
        model.addAttribute("listAlbum",albumService.findAll());
        return "listAlbum";
    }

    @GetMapping("/album/delete/{id}")
    public String deleteAlbum(@PathVariable Long id, Model model){
        albumService.deleteAlbumById(id);
        model.addAttribute("listAlbum",albumService.findAll());
        return "listAlbum";
    }
    @GetMapping("/album/add-form")
    public String getAddAlbumPage(Model model){
        model.addAttribute("albumList",albumService.findAll());
        return "add-album";
    }
    @GetMapping("/album/edit-form/{id}")
    public String editForm(Model model,@PathVariable Long id){
        model.addAttribute("albumList",albumService.findAll());
        Album album = albumService.findById(id);
        model.addAttribute("album",album);
        return "add-album";
    }
}