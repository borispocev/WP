package mk.ukim.finki.wp.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import mk.ukim.finki.wp.lab.model.Genre;

public interface GenreRepositoryInt extends JpaRepository<Genre, Long>{
}
