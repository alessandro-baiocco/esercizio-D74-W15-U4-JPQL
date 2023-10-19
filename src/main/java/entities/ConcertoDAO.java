package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ConcertoDAO {
    private EntityManager em;

    public ConcertoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Concerto cd) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(cd);
            transaction.commit();
            System.out.println("Nuovo evento salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Concerto findById(long id) {
        return em.find(Concerto.class, id);
    }

    public void delete(long id) {
        Concerto concertFounded = em.find(Concerto.class, id);
        try {
            if (concertFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(concertFounded);
                System.out.println("ok");
                transaction.commit();
                System.out.println("il concerto è stato cancellato correttamente");
            } else {
                System.err.println("il concerto non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


}
