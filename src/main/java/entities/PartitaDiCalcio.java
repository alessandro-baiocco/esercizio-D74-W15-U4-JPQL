package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Event {

    private String squadraCasa;

    private String squadraOspite;

    private String vincitore;

    private int golSquadraCasa;

    private int golOspite;


    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, String vincitore, int golSquadraCasa, int golOspite) {
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.vincitore = vincitore;
        this.golSquadraCasa = golSquadraCasa;
        this.golOspite = golOspite;
    }

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, int golSquadraCasa, int golOspite) {
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.golSquadraCasa = golSquadraCasa;
        this.golOspite = golOspite;
    }


    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", vincitore='" + vincitore + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golOspite=" + golOspite +
                '}';
    }
}
