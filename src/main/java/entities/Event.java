package entities;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Event {
    @Id
    @GeneratedValue
    private long ID;

    public Event() {

    }

    public long getID() {
        return ID;
    }
}
