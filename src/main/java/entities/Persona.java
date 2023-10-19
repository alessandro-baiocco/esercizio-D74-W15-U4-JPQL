package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Persona {
    @Id
    @GeneratedValue
    private long ID;

    private String nome;

    private String cognome;

    private int eta;
}
