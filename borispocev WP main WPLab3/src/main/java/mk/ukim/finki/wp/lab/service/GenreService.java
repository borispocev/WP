package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Genre;

import java.util.List;

public interface GenreService {
    public List<Genre> listAll();
    public Genre addGenre(String name);
}
