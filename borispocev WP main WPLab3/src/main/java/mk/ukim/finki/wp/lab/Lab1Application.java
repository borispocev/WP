package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.repository.GenreRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {

    @Autowired
    private GenreRepositoryInt genreRepositoryInt;

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
    }
}
