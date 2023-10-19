package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Event {


    Random rnd = new Random();
    @ManyToMany
    @JoinTable(name = "atletico_gare",
            joinColumns = @JoinColumn(name = "racing_id"),
            inverseJoinColumns = @JoinColumn(name = "atletic_id"))
    private List<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(List<Persona> atleti, Persona vincitore) {
        this.atleti = atleti;
        this.vincitore = atleti.get(rnd.nextInt(0, atleti.size()));
    }


    public List<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
