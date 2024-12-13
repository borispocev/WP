package mk.ukim.finki.wp.lab.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private String genre;
    private String releaseYear;
    @OneToMany(mappedBy = "album")
    private List<Song> songs;
    @ManyToOne
    private Genre genre;

    public Album( String name, String releaseYear) {
        this.name = name;
//        this.genre = genre;
        this.releaseYear = releaseYear;
//        this.id = UUID.randomUUID().getLeastSignificantBits()+UUID.randomUUID().getMostSignificantBits();
    }
}
