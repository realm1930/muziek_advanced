package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;

import java.util.Optional;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

public interface AlbumService {
    Optional<Album> findById(long id);
}
