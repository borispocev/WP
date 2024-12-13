package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepositoryInt;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AtristServiceImpl implements ArtistService{
    private ArtistRepositoryInt artistRepository;
    public AtristServiceImpl(ArtistRepositoryInt artistRepository){
        this.artistRepository=artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).get();
    }


}
