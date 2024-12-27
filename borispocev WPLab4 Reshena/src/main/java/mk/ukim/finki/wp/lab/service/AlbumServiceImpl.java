package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepositoryInt;
import mk.ukim.finki.wp.lab.repository.GenreRepositoryInt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService{
    private final AlbumRepositoryInt albumRepository;
    private final GenreRepositoryInt genreRepository;
    public AlbumServiceImpl(AlbumRepositoryInt albumRepository, GenreRepositoryInt genreRepository) {
        this.albumRepository=albumRepository;
        this.genreRepository = genreRepository;
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
    public Album addAlbum(String name, String releaseYear) {
        return albumRepository.save(new Album(name,releaseYear));
    }

    @Override
    public Album addAlbum(Album album){
        return albumRepository.save(album);
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
    public Album modifyAlbum(Long albumId, String albumName, String releaseYear) {
        Optional<Album> album = albumRepository.findById(albumId);
        album.get().setName(albumName);
        album.get().setReleaseYear(releaseYear);
        return albumRepository.save(album.get());
    }

//    @Override
//    public Album modifyAlbum(Long albumId, String albumName, String albumGenre, String releaseYear) {
//        Optional<Album> album = albumRepository.findById(albumId);
////        album.get().setGenre(albumGenre);
//        album.get().setName(albumName);
//        album.get().setReleaseYear(releaseYear);
//        return albumRepository.save(album.get());
//    }

    @Override
    public Album setGenre(Album album, Long genreId) {
        Optional<Genre> genre = genreRepository.findById(genreId);
        album.setGenre(genre.get());
        return albumRepository.save(album);
    }
}
