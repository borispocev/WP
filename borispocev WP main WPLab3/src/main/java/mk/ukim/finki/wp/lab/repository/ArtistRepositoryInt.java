package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepositoryInt extends JpaRepository<Artist, Long> {
}