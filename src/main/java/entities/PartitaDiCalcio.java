package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Event {
    @Id
    @GeneratedValue
    private long id;


}
