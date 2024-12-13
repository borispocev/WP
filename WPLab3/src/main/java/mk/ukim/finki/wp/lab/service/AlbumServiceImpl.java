package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepositoryInt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService{
    private final AlbumRepositoryInt albumRepository;
    public AlbumServiceImpl(AlbumRepositoryInt albumRepository) {
        this.albumRepository=albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album addSongToAlbum(Long albumId, Song song) {
        Optional<Album> album = albumRepository.findById(albumId);
        album.get().getSongs().add(song);
        return album.get();
    }

    @Override
    public Album addAlbum(String name, String genre, String releaseYear) {
        return albumRepository.save(new Album(name,genre,releaseYear));
    }

    @Override
    public  Album deleteAlbumById(Long id){
        Optional<Album> album = albumRepository.findById(id);
        albumRepository.deleteById(id);
        return album.get();
    }

    @Override
    public Album findById(Long id) {
        Optional<Album> album = albumRepository.findById(id);
        return album.get();
    }

    @Override
    public Album addSongToAlbum(Song song, Long albumId) {
        Optional<Album> album = albumRepository.findById(albumId);
        album.get().getSongs().add(song);
        return album.get();
    }

    @Override
    public Album modifyAlbum(Long albumId, String albumName, String albumGenre, String releaseYear) {
        Optional<Album> album = albumRepository.findById(albumId);
        album.get().setGenre(albumGenre);
        album.get().setName(albumName);
        album.get().setReleaseYear(releaseYear);
        return albumRepository.save(album.get());
    }
}
