package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService{
    private AlbumRepository albumRepository;
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository=albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
    public Album addSongToAlbum(Long albumId, Song song){
        return albumRepository.addSongToAlbum(song,albumId);
    }

    @Override
    public Album addAlbum(String name, String genre, String releaseYear) {
        Album album = new Album(name,genre,releaseYear);
        albumRepository.addAlbum(album);
        return album;
    }

    @Override
    public  Album deleteAlbumById(Long id){
        Album album=albumRepository.deleteById(id);
        return album;
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public Album modifyAlbum(Long albumId, String albumName, String albumGenre, String releaseYear) {
        return  albumRepository.modifyAlbum(albumId, albumName,albumGenre,releaseYear);
    }
}
