package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.repository.GenreRepositoryInt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    private final GenreRepositoryInt genreRepository;

    public GenreServiceImpl(GenreRepositoryInt genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public List<Genre> listAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre addGenre(String name) {
        return genreRepository.save(new Genre(name));
    }
}
