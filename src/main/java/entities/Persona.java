package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private long ID;

    private String nome;

    private String cognome;

    @ManyToMany
    @JoinTable(name = "atletico_gare",
            joinColumns = @JoinColumn(name = "atletic_id"),
            inverseJoinColumns = @JoinColumn(name = "racing_id"))
    private List<GaraDiAtletica> gare;

    private int eta;
}
