package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Event {
    @Id
    @GeneratedValue
    private long id;
}
