package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.GenreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
public class AlbumController {

    private final AlbumService albumService;
    private final GenreService genreService;

    public AlbumController(AlbumService albumService, GenreService genreService) {
        this.albumService = albumService;
        this.genreService = genreService;
    }

    @PostMapping("/album")
    public String getAlbumByGenre(@RequestParam String genre, Model model){
        Genre genre1 = genreService.listAll().stream().filter(el -> el.getName().equals(genre)).findFirst().orElse(null);
        model.addAttribute("listGenre", genreService.listAll().stream().filter(el -> el.getName().equals(genre)).findFirst());
        model.addAttribute("listAlbum",albumService.findAll().stream().filter(el -> el.getGenre().getName().equals(genre)).collect(Collectors.toList()));
        return "listAlbum";
    }
//    @GetMapping("/album")
//    public String getGenre(@RequestParam(required = false) String error, Model model){
//        model.addAttribute("listGenre", genreService.listAll());
//        model.addAttribute("listAlbum",albumService.findAll());
//        return "listAlbum";
//    }


    @GetMapping("/album")
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("bodyContent", "user");
        model.addAttribute("listGenre", genreService.listAll());
        model.addAttribute("listAlbum",albumService.findAll());
        return "listAlbum";
    }
    @PostMapping("/album/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String saveAlbum(
            @RequestParam String albumName,
            @RequestParam String releaseYear,
            @RequestParam Long genreId,
            Model model){

        Album album=albumService.addAlbum(albumName,releaseYear);
        albumService.setGenre(album, genreId);
        model.addAttribute("listAlbum",albumService.findAll());
        return  "listAlbum";

    }

    @PostMapping("/album/edit/{albumId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String editSong(@PathVariable Long albumId,
                           @RequestParam String albumName,
                           @RequestParam String releaseYear,
                           @RequestParam Long genreId,
                           Model model){
        Album album = albumService.modifyAlbum(albumId,albumName,releaseYear);
        albumService.setGenre(album, genreId);
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
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String getAddAlbumPage(Model model){
        model.addAttribute("albumList",albumService.findAll());
        model.addAttribute("genreList", genreService.listAll());
        return "add-album";
    }
    @GetMapping("/album/edit-form/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String editForm(Model model,@PathVariable Long id){
        model.addAttribute("albumList",albumService.findAll());
        model.addAttribute("genreList", genreService.listAll());
        Album album = albumService.findById(id);
        model.addAttribute("album",album);
        return "add-album";
    }
}
