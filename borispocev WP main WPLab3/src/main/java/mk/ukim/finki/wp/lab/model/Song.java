package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Song {
    String trackId;
    String  title;
    String  genre;
    String category;
    int releaseYear;
    @ManyToOne
    Album album;
    @OneToMany
    List<Artist> artisti;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
//        this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits()+UUID.randomUUID().getMostSignificantBits());
    }

    @Override
    public String toString() {
        return "Song{" +
                "trackId='" + trackId + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

//    public void addPerformer(Artist performer) {
//        performer.add(performer);
//    }
}
