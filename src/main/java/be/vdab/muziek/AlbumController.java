package be.vdab.muziek;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.services.AlbumService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@RestController
@RequestMapping("albums")
@ExposesResourceFor(Album.class)
class AlbumController {

    private final AlbumService albumService;
    private final TypedEntityLinks.ExtendedTypedEntityLinks<Album> links;

    public AlbumController(AlbumService albumService, EntityLinks links) {
        this.albumService = albumService;
        this.links = links.forType(Album.class, Album::getId);
    }
    @GetMapping("{id}")
    EntityModel<AlbumArtiest> getAlbum(@PathVariable long id){
        return albumService.findById(id).map(album ->
                EntityModel.of(new AlbumArtiest(album))
        .add(links.linkToItemResource(album))
        .add(links.linkForItemResource(album).slash("tracks").withRel("tracks")))
                .orElseThrow(AlbumNietGevondenException::new);
    }

    

    private static class AlbumArtiest {
        private final String album;
        private final String artiest;

        public AlbumArtiest(Album album) {
            this.album = album.getNaam();
            this.artiest = album.getArtiest().getNaam();
        }
    }
}
