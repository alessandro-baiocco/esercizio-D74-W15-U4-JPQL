package entities;


import enums.Genere;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "concerto")
public class Concerto extends Event {

    @Enumerated(EnumType.STRING)
    private Genere genere;

    private Boolean streaming;


    public Concerto() {
    }

    public Concerto(Genere genere, Boolean streaming) {
        this.genere = genere;
        this.streaming = streaming;
    }


    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Boolean getStreaming() {
        return streaming;
    }

    public void setStreaming(Boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", streaming=" + streaming +
                '}';
    }
}


