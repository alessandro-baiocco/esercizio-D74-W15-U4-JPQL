package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GaraDiAtleticaDAO {
    private EntityManager em;

    public GaraDiAtleticaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(event);
            transaction.commit();
            System.out.println("Nuovo evento salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public GaraDiAtletica findById(long id) {
        return em.find(GaraDiAtletica.class, id);
    }

    public void delete(long id) {
        GaraDiAtletica eventFounded = em.find(GaraDiAtletica.class, id);
        try {
            if (eventFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(eventFounded);
                System.out.println("ok");
                transaction.commit();
                System.out.println("l'evento o è stato cancellato correttamente");
            } else {
                System.err.println("l'evento non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


}
