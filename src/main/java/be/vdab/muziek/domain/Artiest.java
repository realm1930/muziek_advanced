package be.vdab.muziek.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@Entity
@Table(name = "artiesten")
public class Artiest {
    @Id
    private long id;
    private String naam;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
