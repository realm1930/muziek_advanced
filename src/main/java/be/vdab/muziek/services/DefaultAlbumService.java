package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.repositories.AlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@Service
@Transactional
class DefaultAlbumService implements AlbumService{
    private final AlbumRepository albumRepository;

    public DefaultAlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Optional<Album> findById(long id) {
        return albumRepository.findById(id);
    }
}
