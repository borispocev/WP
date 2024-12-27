package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface AlbumService {
    public List<Album> findAll();

    public Album addSongToAlbum(Long albumId, Song song);

    public Album addAlbum(String name, String releaseYear);

    public Album deleteAlbumById(Long id);

    public Album findById(Long id);
    Album addSongToAlbum(Song song, Long albumId);

    Album modifyAlbum(Long albumId, String albumName, String releaseYear);

    Album setGenre(Album album, Long genreId);

    Album addAlbum(Album album);
}
