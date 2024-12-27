package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.repository.AlbumRepositoryInt;
import mk.ukim.finki.wp.lab.repository.GenreRepositoryInt;
import mk.ukim.finki.wp.lab.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {

    @Autowired
    private GenreRepositoryInt genreRepositoryInt;

    @Autowired
    private AlbumService albumService;


    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Genre genre1 = new Genre("Rock");
        Genre genre2 = new Genre("Rap");
        Genre genre3 = new Genre("Hip-hop");

        genreRepositoryInt.save(genre1);
        genreRepositoryInt.save(genre2);
        genreRepositoryInt.save(genre3);

        Album album1 = new Album("Gradutaion", "2017");
        this.albumService.addAlbum(album1);
        this.albumService.setGenre(album1, 3L);

        Album album2 = new Album("Pink Galaxy", "2000");
        this.albumService.addAlbum(album2);
        this.albumService.setGenre(album2, 1L);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
