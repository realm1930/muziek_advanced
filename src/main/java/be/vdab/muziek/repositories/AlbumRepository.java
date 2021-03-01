package be.vdab.muziek.repositories;

import be.vdab.muziek.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

public interface AlbumRepository extends JpaRepository<Album,Long> {
}
