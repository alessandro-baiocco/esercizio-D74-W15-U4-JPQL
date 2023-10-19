package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartitaDiCalcioDAO {
    private EntityManager em;

    public PartitaDiCalcioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PartitaDiCalcio event) {
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


    public PartitaDiCalcio findById(long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public void delete(long id) {
        PartitaDiCalcio eventFounded = em.find(PartitaDiCalcio.class, id);
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