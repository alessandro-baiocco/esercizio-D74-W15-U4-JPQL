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

    public Persona() {
    }

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public long getID() {
        return ID;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<GaraDiAtletica> getGare() {
        return gare;
    }

    public void setGare(List<GaraDiAtletica> gare) {
        this.gare = gare;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
