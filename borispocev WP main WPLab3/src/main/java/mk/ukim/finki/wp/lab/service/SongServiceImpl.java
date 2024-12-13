package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepositoryInt;
import mk.ukim.finki.wp.lab.repository.ArtistRepositoryInt;
import mk.ukim.finki.wp.lab.repository.SongRepositoryInt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private SongRepositoryInt songRepository;
    private ArtistRepositoryInt artistRepository;
    private AlbumRepositoryInt albumRepository;

    public SongServiceImpl(SongRepositoryInt songRepository, ArtistRepositoryInt artistRepository, AlbumRepositoryInt albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }


    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getArtisti().add(artist);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        Optional<Song> song = songRepository.findAll().stream().filter(el -> el.getTrackId().equals(trackId)).findFirst();
        return song.get();
    }

    @Override
    public Song findByCategory(String category) {
        Optional<Song> song = songRepository.findAll().stream().filter(el -> el.getGenre().equals(category)).findFirst();
        return song.get();
    }
    @Override
    public Song addSong(String trackId, String title, String genre, int releaseYear){
        Song song = new Song(trackId,title,genre,releaseYear);
        songRepository.save(song);
        return song;
    }
    @Override
    public Song modifySong(Long id, String trackId, String title, String genre, int releaseYear){
        Optional<Song> song = songRepository.findById(id);
        song.get().setGenre(genre);
        song.get().setReleaseYear(releaseYear);
        song.get().setTitle(title);
        song.get().setTrackId(trackId);
        return songRepository.save(song.get());
    }
    @Override
    public Song deleteSongById(Long id){
        Optional<Song> song = songRepository.findById(id);
        songRepository.deleteById(id);
        return song.get();
    }
    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).get();
    }

    @Override
    public Song setAlbum(Long songId, Long albumId) {
        Optional<Song> song = songRepository.findById(songId);
        Optional<Album> album = albumRepository.findById(albumId);
        song.get().setAlbum(album.get());
        return songRepository.save(song.get());
    }

}
