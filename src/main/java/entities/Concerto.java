package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "concerto")
public class Concerto extends Event {
    @Id
    @GeneratedValue
    private long id;
}
